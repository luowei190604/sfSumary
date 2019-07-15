package com.source.analy.diyParse;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import com.source.analy.model.User;

public class DiyParaser extends AbstractSingleBeanDefinitionParser{

	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}
	
	
	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String email = element.getAttribute("email");
		String id = element.getAttribute("id");
		if(StringUtils.hasText(name)){
			builder.addPropertyValue("name", name);
		}
		if(StringUtils.hasText(email)){
			builder.addPropertyValue("email", email);
		}
		if(StringUtils.hasText(id)){
			builder.addPropertyValue("id",id);
		}
	}
}
