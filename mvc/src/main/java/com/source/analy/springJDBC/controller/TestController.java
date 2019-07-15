package com.source.analy.springJDBC.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.source.analy.springJDBC.model.User;

@RestController
public class TestController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public User getUserById(Long id,HttpServletRequest request,HttpServletResponse response){
		Enumeration<String> attributeNames = request.getAttributeNames();
		while(attributeNames.hasMoreElements()){
			String nextElement = attributeNames.nextElement();
			System.out.println(nextElement);
		}
		User user = new User();
		user.setName("zhangsa");
		user.setId(11);
		return user;
	}
}
