package com.daniel.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetApiApplication.class, args);
	}

}
