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
        return new ApiInfo("Spring Boot REST API",
                "Spring Boot REST API for CRUD project. Simple app for flights reservation. ",
                "version: 1.00",
                "",
                new Contact("Krzyszof Wójcik", "https://www.linkedin.com/in/krzysztof-w%C3%B3jcik-2344a1192/", "kristricity@gmail.com"),
                "License: PUBLIC.",
                "",
                Collections.emptyList());
    }
}