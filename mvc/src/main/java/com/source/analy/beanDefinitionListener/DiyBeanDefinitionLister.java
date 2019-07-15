package com.source.analy.beanDefinitionListener;

import org.springframework.beans.factory.parsing.ComponentDefinition;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;

public class DiyBeanDefinitionLister extends EmptyReaderEventListener{

	@Override
	public void componentRegistered(ComponentDefinition componentDefinition) {
		String name = componentDefinition.getName();
		System.out.println("IOC容器已经成功注册"+name+"bean");
	}
}
