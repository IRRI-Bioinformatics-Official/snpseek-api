package org.irri.snpseek.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI snpSeekOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:5555/api");
        server.setDescription("SNPSeek API Server");

        Contact contact = new Contact();
        contact.setName("SNPSeek Team");

        Info info = new Info()
                .title("SNPSeek Rice Genomics API")
                .version("1.0")
                .contact(contact)
                .description("API for querying rice variety, phenotype, genotype, and genomic data");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}