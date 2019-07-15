package com.source.analy.model;

import org.springframework.stereotype.Component;

import com.source.analy.annotation.MyAnnotation;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@Component
@MyAnnotation(value="zhangsan")
public class Car {

	private String maxSpeed;
	
	private String beand;
	
	private double price;
	
	public void sayhello(){
		System.out.println("haha");
	}
}
