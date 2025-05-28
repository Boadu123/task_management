package com.ben.spring_boot;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();

		System.setProperty("MySQL_User", dotenv.get("MySQL_User"));
		System.setProperty("MySQL_Password", dotenv.get("MySQL_Password"));
		System.setProperty("MySQL_Database", dotenv.get("MySQL_Database"));
		SpringApplication.run(Application.class, args);
	}
}
