package com.luv2code.springcoredemo.config;


import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

	//As a default bean id must be same with Class name which return, just except a first char lowercase
	//But we can give a custom bean id with pass a parameter to Bean annotation
	@Bean("CustomName")
	public Coach swimCoach(){
		return new SwimCoach();
	}
}
