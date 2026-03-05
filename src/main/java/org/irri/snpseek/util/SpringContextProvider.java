package org.irri.snpseek.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Simple holder for Spring ApplicationContext so non-managed classes can access beans.
 * This will be initialized automatically when Spring creates the bean (if component scanning
 * includes this package). If not present, callers should handle null.
 */
@Component
public class SpringContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextProvider.context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}
