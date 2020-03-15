package com.apache.solr.SolrTemplateExample.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.apache.solr.SolrTemplateExample.controller"))
                .paths(regex("/student.*"))
                .build()
                .apiInfo(apiInfo);
    }

    // /student.+ --> only get endpoints - /students and /students/all
    // /student.* --> all endpoints - /students, /students/all, /student(POST)
    // /student   --> only /student (POST)

    private ApiInfo apiInfo = new ApiInfo(
            "First Swagger",
            "This is my first swagger demo app",
            "1.0",
            "Student TermsOfService",
            new Contact("Meenakshi Sundaram", "https://github.com/meenakshisund", "xyz@abc.com"),
            "license GPU",
            "licenseUrl"
    );
}