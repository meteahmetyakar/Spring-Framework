package com.example.demo;

import com.example.demo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO)
	{

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO);


		};

	}


	private void demoTheBeforeAdvice(AccountDAO theAccountDAO)
	{
		//business logic

		theAccountDAO.addAccount();

		System.out.println("\n let's call it again!\n");

		theAccountDAO.addAccount();
		


	}


}
