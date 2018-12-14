package com.dream.confuguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket ProductApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false)
				.forCodeGeneration(false).pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dream.controller"))
                .paths(PathSelectors.any())
				.build()
				.apiInfo(productApiInfo());
	}

	private ApiInfo productApiInfo() {
		return new ApiInfoBuilder()
		        .title("Dreamside Maroon Service API")
		        .description("Dreamside Maroon Service API")
		        .license("License")
		        .licenseUrl("http://choosealicense.com/no-license/")
		        .termsOfServiceUrl("http://www.DreamsideMaroon.cn/")
		        .version("1.0.0")
		        .build();
	}
}