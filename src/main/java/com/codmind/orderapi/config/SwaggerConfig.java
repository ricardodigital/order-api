package com.codmind.orderapi.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder().
							name("Authorization")
							.description("Token de autenticación").modelRef(new ModelRef("string"))
							.parameterType("header")
							.required(false)
							.build()
						))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.codmind.orderapi.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API REST",
				"REST API technical test carried out with the help of the course: Mastering REST API with Spring Boot by Codmind",
				"1.0",
				"",
				new Contact("Ricardo Chaves", "", "ingeniero@ricardochaves.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
