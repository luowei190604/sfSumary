package com.source.analy.diyBeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.source.analy.processor.MyDiyProcessor;

public class DiyFirstBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("开始调用beanFactoryPostProcessor");
//		Object bean = beanFactory.getBean("user");
//		System.out.println(bean.getClass());
		beanFactory.addBeanPostProcessor(new MyDiyProcessor());
	}
	
}
