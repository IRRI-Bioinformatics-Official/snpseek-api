package org.irri.snpseek.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple utility to load snpseek.properties and expose commonly used values.
 * Lookup order for a property (highest -> lowest):
 * 1) System property (System.getProperty)
 * 2) Environment variable (for specific keys)
 * 3) External properties file indicated by system property 'snpseek.config.path' or env 'SNPSEEK_CONFIG_PATH'
 * 4) ./bin/snpseek.properties (relative to working dir)
 * 5) classpath resource 'snpseek.properties' or 'bin/snpseek.properties'
 *
 * This class caches the loaded Properties for subsequent lookups.
 */
public final class PropertyUtil {

    private static final Logger logger = Logger.getLogger(PropertyUtil.class.getName());
    private static final AtomicReference<Properties> cached = new AtomicReference<>();
    private static final String SYS_CFG_PATH = "snpseek.config.path";
    private static final String ENV_CFG_PATH = "SNPSEEK_CONFIG_PATH";

    private PropertyUtil() {}

    private static Properties loadIfNeeded() {
        Properties p = cached.get();
        if (p != null) return p;
        Properties loaded = new Properties();

        // 1) explicit path via system property
        String explicit = System.getProperty(SYS_CFG_PATH);
        if (isBlank(explicit)) {
            explicit = System.getenv(ENV_CFG_PATH);
        }

        if (!isBlank(explicit)) {
            Path path = Paths.get(explicit.trim());
            if (Files.exists(path) && Files.isReadable(path)) {
                try (InputStream in = Files.newInputStream(path)) {
                    loaded.load(in);
                    cached.compareAndSet(null, loaded);
                    logger.info("PropertyUtil: loaded properties from explicit path: " + path.toString());
                    return loaded;
                } catch (IOException e) {
                    logger.log(Level.WARNING, "PropertyUtil: failed to load properties from explicit path " + path, e);
                }
            } else {
                logger.warning("PropertyUtil: explicit config path does not exist or is unreadable: " + path);
            }
        }

        // 2) default relative: ./bin/snpseek.properties
        Path rel = Paths.get(System.getProperty("user.dir", ".")).resolve("bin").resolve("snpseek.properties").toAbsolutePath();
        if (Files.exists(rel) && Files.isReadable(rel)) {
            try (InputStream in = Files.newInputStream(rel)) {
                loaded.load(in);
                cached.compareAndSet(null, loaded);
                logger.info("PropertyUtil: loaded properties from relative path: " + rel.toString());
                return loaded;
            } catch (IOException e) {
                logger.log(Level.WARNING, "PropertyUtil: failed to load properties from relative path " + rel, e);
            }
        }

        // 3) classpath: snpseek.properties or bin/snpseek.properties
        try (InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("snpseek.properties")) {
            if (in != null) {
                loaded.load(in);
                cached.compareAndSet(null, loaded);
                logger.info("PropertyUtil: loaded properties from classpath resource snpseek.properties");
                return loaded;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "PropertyUtil: failed to load snpseek.properties from classpath", e);
        }

        try (InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("bin/snpseek.properties")) {
            if (in != null) {
                loaded.load(in);
                cached.compareAndSet(null, loaded);
                logger.info("PropertyUtil: loaded properties from classpath resource bin/snpseek.properties");
                return loaded;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "PropertyUtil: failed to load bin/snpseek.properties from classpath", e);
        }

        // nothing found -> cache empty properties
        cached.compareAndSet(null, loaded);
        logger.fine("PropertyUtil: no external properties found; using empty properties");
        return loaded;
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * Get a property by key. System property overrides the loaded properties.
     */
    public static String get(String key) {
        String v = System.getProperty(key);
        if (!isBlank(v)) return v.trim();
        Properties p = loadIfNeeded();
        String fromProps = p.getProperty(key);
        return fromProps != null ? fromProps.trim() : null;
    }

    /**
     * Convenience: returns the flat file directory path. Resolution order:
     * 1) System property 'flatFileDirectory' (or -DflatFileDirectory=...)
     * 2) Environment variable 'FLATFILES_DIR'
     * 3) Property 'flatFileDirectory' in snpseek.properties
     * 4) empty string if none found
     */
    public static String getFlatFileDirectory() {
        String v = System.getProperty("flatFileDirectory");
        if (!isBlank(v)) return v.trim();
        v = System.getenv("FLATFILES_DIR");
        if (!isBlank(v)) return v.trim();
        v = get("flatFileDirectory");
        return v != null ? v : "";
    }

    /**
     * Reset cached properties (useful for tests).
     */
    public static void resetCache() {
        cached.set(null);
    }
}
