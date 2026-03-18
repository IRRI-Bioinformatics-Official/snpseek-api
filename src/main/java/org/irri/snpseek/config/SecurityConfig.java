package org.irri.snpseek.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            // Allow Swagger and API Docs without a token
	            .requestMatchers(
	                "/swagger-ui.html",
	                "/swagger-ui",
	                "/swagger-ui/**", 
	                "/v3/api-docs",
	                "/v3/api-docs/**", 
	                "/api-docs",
	                "/api-docs/**", 
	                "/rest/swagger-ui",
	                "/rest/swagger-ui/**",
	                "/rest/api-docs",
	                "/rest/api-docs/**",
	                "/swagger-resources",
	                "/swagger-resources/**", 
	                "/webjars/**"
	            ).permitAll()	            // Protect your actual data and any other endpoint
	            .anyRequest().authenticated()
	        )
	        .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
	    return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(
			"https://brs-snpseek.duckdns.org",
			"https://snpseekv3.duckdns.org",
			"http://localhost:5555",
			"http://localhost:5556",
			"http://localhost:3000"
		));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}