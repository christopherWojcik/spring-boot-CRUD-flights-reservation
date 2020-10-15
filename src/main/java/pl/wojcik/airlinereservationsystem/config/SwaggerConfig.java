package pl.wojcik.airlinereservationsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.wojcik.airlinereservationsystem.contoller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Aircraft and flights database",
                "Aircraft and flights database for CRUD spring boot project",
                "1.00",
                "",
                new Contact("Christopher", "", "kristricity@gmail.com"),
                "My own licence",
                "",
                Collections.emptyList());
    }
}
