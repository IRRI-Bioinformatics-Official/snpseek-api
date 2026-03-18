package org.irri.snpseek.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.Components;

@Configuration
public class OpenApiConfig {

	 @Value("${app.public-url}")
	 private String publicUrl;

    @Bean
    public OpenAPI snpSeekOpenAPI() {
        final String bearerAuth = "bearerAuth";
        final String oauth2Auth = "keycloakAuth";

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

        // Keycloak endpoints
        String keycloakBaseUrl = "https://brs-snpseek.duckdns.org/auth/realms/snpseek_realm/protocol/openid-connect";

        return new OpenAPI()
                .info(info)
                .servers(List.of(server))
                .addSecurityItem(new SecurityRequirement().addList(bearerAuth))
                .addSecurityItem(new SecurityRequirement().addList(oauth2Auth))
                .components(new Components()
                    .addSecuritySchemes(bearerAuth,
                        new SecurityScheme()
                            .name(bearerAuth)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT"))
                    .addSecuritySchemes(oauth2Auth,
                        new SecurityScheme()
                            .type(SecurityScheme.Type.OAUTH2)
                            .description("Keycloak OAuth2 Flow")
                            .flows(new OAuthFlows()
                                .authorizationCode(new OAuthFlow()
                                    .authorizationUrl(keycloakBaseUrl + "/auth")
                                    .tokenUrl(keycloakBaseUrl + "/token")
                                    .scopes(new Scopes().addString("openid", "standard openid scope"))
                                )))
                );
    }
}