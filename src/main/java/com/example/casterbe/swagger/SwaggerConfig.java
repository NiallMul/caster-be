package com.example.casterbe.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket castersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }

    //TODO: Replace apiInfo with current best practice
    private ApiInfo metaData() {
        return new ApiInfo(
                "caster application",
                "personel project for tracing caster power usage",
                "0.01",
                "",
                "niallmulready@gmail.com",
                "licensne",
                "licenseUrl");
    }

}
