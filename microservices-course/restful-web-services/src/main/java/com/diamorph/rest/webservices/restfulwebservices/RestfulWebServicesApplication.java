package com.diamorph.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		I18nConfiguration();
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	public static void I18nConfiguration() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
	}

}
