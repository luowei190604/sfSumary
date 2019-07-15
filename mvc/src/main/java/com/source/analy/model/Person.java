package com.source.analy.model;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@Service
public class Person {
	int age;
	String name;
	String email;
	
	public void doKafkamessage(){
		System.out.println("send message:---");
	}
}
