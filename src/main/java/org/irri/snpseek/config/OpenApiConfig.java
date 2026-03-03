package org.irri.snpseek.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	 @Value("${app.public-url}")
	 private String publicUrl;
	 
    @Bean
    public OpenAPI snpSeekOpenAPI() {
        Server server = new Server();
        server.setUrl(publicUrl);
        server.setDescription("SNPSeek API Server v1.0.2");

        Contact contact = new Contact();
        contact.setName("SNPSeek Team");

        Info info = new Info()
                .title("SNPSeek Rice Genomics API (BETA)")
                .version("1.0.2")
                .contact(contact)
                .description("API for querying rice variety, phenotype, genotype, and genomic data. This API is currently in BETA and may undergo changes. Please report any issues to the SNPSeek Team.");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}