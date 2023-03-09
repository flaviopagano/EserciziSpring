package com.example.Swagger1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfo(
                        "swagger example",
                        "A simple swagger example API documentation",
                        "1.0.0",
                        "https://example",
                        new Contact("Flavio", "https://example", "flavio@gmail.com"),
                        "AAA",
                        "https://example",
                        Collections.emptyList()
                )).tags(
                        new Tag("controller", "Controller that returns my name")
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My Name API")
                .description("API for retrieving my name")
                .version("1.0.0")
                .build();
    }
}
