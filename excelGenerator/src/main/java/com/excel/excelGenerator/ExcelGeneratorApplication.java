package com.excel.excelGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ExcelGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelGeneratorApplication.class, args);
		System.out.println("----------------------EXCEL GENERATOR APPLICATION---------------------------");
		System.out.println("----------------------THIS ACCEPTS JSON DATA INPUT AND RETURNS XLS/XLSX FILE FORMAT---------------------------");
		System.out.println("----------------------WHEN IT SUCCESSFULLY STARTS, PLEASE ACCESS THE APPLICATION USING BELOW URL---------------------------");
		System.out.println("----------------------ROOT URL -- http://localhost:8083/excelGenerator---------------------------");
		System.out.println("----------------------API DOCUMENTATION URL -- http://localhost:8083/swagger-ui.html---------------------------");
	}

	@Bean
	public Docket swaggerSpringMvcPlugin() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()	
	            .apis(RequestHandlerSelectors.basePackage("com.excel.excelGenerator"))
	            .paths(PathSelectors.any())               
	            .build();
	  }
}
