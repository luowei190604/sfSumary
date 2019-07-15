package com.source.analy.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.source.analy.annotation.service.TestService;

@Configuration
public class Config {

	@Bean
	public TestService testService(){
		
		return new TestService();
	}
}
