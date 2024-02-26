package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class CricketCoach implements Coach{

	public CricketCoach() {
		System.out.println("In cons: " + getClass().getSimpleName());
	}

	//define our init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
	}

	//define our destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() { return "Practice fast bowling for 15 minutes :- setter injection"; }
}
