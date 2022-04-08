package com.poli.project.config;


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

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	
	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.basePackage("co.edu.poli.mongodb.controller")) //Specific package
				.apis(RequestHandlerSelectors.basePackage("com.poli")) //All project
				//.paths(PathSelectors.regex("/api/v1.*")) //filter RequestMapping with regular expression
				.paths(PathSelectors.any())
				.build()
				.apiInfo(proyectoCustomerApiInfo())
				.tags(new Tag("Class: PoblacionController", "*** Customer Controller ***"));
	}

	private ApiInfo proyectoCustomerApiInfo() {
		return new ApiInfoBuilder()
				.title("My Spring Boot REST API")
				.description("Customer REST API")
				.contact(new Contact("Web App Proyecto Final", "", "jopinzon19@poligran.edu.co"))
				.version("0.0.1")
				.build();
	}
	
	 
}