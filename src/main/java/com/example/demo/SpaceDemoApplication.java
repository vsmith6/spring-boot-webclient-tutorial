package com.example.demo;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.AstroResponse;



@SpringBootApplication
public class SpaceDemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpaceDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpaceDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception
	
	{
		return args -> {
			AstroResponse response = restTemplate.getForObject(
					"http://api.open-notify.org/astros.json", AstroResponse.class);
			log.info(response.toString());
		};
	}

}
