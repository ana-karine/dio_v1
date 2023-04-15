package com.example.dioclass.apirest.MyFirstApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			personRepository.save(new Person("João","Silva"));
			personRepository.save(new Person("Maria","Antonieta"));
			personRepository.save(new Person("Ada","Lovace"));
		};
	}

}
