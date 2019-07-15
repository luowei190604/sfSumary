package com.source.analy.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testMapping")
public class ControllerRequestMapping {

	//@GetMapping("/say")
	@RequestMapping(value="say",method=RequestMethod.GET)
	@ResponseBody
	public void say(String msg){
		System.out.println("hello "+msg);
	}
	

}
