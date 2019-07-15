package com.source.analy.diyHandler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.source.analy.diyParse.DiyParaser;

public class DiyHandler extends NamespaceHandlerSupport{

	public void init() {
		registerBeanDefinitionParser("user", new DiyParaser());
	}
	
}
