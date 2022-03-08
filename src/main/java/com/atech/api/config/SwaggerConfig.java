package com.atech.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI addDocumentation() {
		
		Contact contact = new Contact();
		contact.setName("Ra'ed Abu Sa'da");
		contact.setEmail("raed@atech.ps");
		contact.setUrl("http://www.atech.com/raed");
		
		return new OpenAPI().
				info( new Info().contact(contact).description("Customer API exposing all endpoints for learning purposes").version("Apache v 1.05")
				.license(new License().name("Apache Maven v3.4").name("Apache Foundation").url("http://org.maven.api")))
				.externalDocs(new ExternalDocumentation().description("Full Documented Customer API").url("http://www.api.documentation.swagger/customerApi"));
		
	}

}
