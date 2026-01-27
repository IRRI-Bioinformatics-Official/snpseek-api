package org.irri.test;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
public class DatabaseConfig {
 
 @Bean
 CommandLineRunner testConnection(DataSource dataSource) {
     return args -> {
         try (Connection connection = dataSource.getConnection()) {
             System.out.println("✅ Database connected successfully!");
             System.out.println("   URL: " + connection.getMetaData().getURL());
             System.out.println("   Database: " + connection.getCatalog());
             System.out.println("   User: " + connection.getMetaData().getUserName());
         } catch (Exception e) {
             System.err.println("❌ Database connection failed: " + e.getMessage());
         }
     };
 }
}