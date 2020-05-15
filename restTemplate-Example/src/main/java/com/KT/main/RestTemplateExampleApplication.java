package com.KT.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.KT.main.entity.Person;
import com.KT.main.repository.PersonRepository;

@SpringBootApplication
public class RestTemplateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateExampleApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	}
	
	@Bean
	CommandLineRunner start(PersonRepository personRepository) {
		return args -> {
//			personRepository.save(new person("HAMZA", "LOUNISSI", 26));
//			personRepository.save(new person("Imad", "AFFAR", 30));
		};
	}
}
