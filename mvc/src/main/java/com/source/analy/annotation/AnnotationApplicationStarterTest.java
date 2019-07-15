package com.source.analy.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.source.analy.annotation.service.TestService;

public class AnnotationApplicationStarterTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		System.out.println(context.getBean(TestService.class));
	}
}
