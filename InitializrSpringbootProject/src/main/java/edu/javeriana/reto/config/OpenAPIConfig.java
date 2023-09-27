package edu.javeriana.reto.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

/**
 *
 * @author dinan
 */
@Configuration
public class OpenAPIConfig {

    @Value("${edu.javeriana.des_url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL de Desarrollo para ver los Servicios actuales");

        Contact contact = new Contact();
        contact.setEmail("fe.castillo@javeriana.edu.co");
        contact.setName("Fabio Castillo");
        contact.setUrl("https://www.javeriana.edu.co//inicio");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Tutorial para la administracion del API")
                .version("1.0")
                .contact(contact)
                .description("Terminos y COndiciones del Uso de la App").termsOfService("condiciones")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}
