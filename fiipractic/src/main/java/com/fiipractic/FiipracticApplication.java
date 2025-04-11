package com.fiipractic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FiipracticApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiipracticApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserService userService) {
		return args -> {
			if (userService.getUserByUsername("admin") == null) {
				UserEntity.User admin = new UserEntity.User("admin", "admin123");
				userService.saveUser(admin);
				System.out.println("Inserted default admin user");
			}
		};
	}
	}
