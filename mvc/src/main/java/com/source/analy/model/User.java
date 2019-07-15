package com.source.analy.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.source.analy.annotation.MyAnnotation;

import lombok.Data;
import lombok.experimental.Accessors;

@MyAnnotation(value = "abc")
public class User /*implements InitializingBean*/{
	
	private String id;
	
	private String name;
	
	private String email;
	
	private Person p;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

//	public void afterPropertiesSet() throws Exception {
//		System.out.println("开始调用afterPropertiesSet");
//	}
//	
//	public void initMethod(){
//		System.out.println("开始调用init-method");
//	}
//	
//	@PostConstruct
//	public void constructor(){
//		System.out.println("开始调用constructor");
//	}
	
	
}
