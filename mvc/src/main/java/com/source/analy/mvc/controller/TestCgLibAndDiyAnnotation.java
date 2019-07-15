package com.source.analy.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.source.analy.annotation.MyAnnotation;

@MyAnnotation("hello")
//@Component
public class TestCgLibAndDiyAnnotation {

	public void say(){
		System.out.println("jied");
	}
}
