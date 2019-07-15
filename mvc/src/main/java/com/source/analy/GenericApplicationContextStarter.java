package com.source.analy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.source.analy.annotation.MyAnnotation;

public class GenericApplicationContextStarter {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		GenericApplicationContext context = new GenericApplicationContext();
//		context.refresh();
//		context.addApplicationListener(new ApplicationListener<ApplicationEvent>(){
//
//			@Override
//			public void onApplicationEvent(ApplicationEvent event) {
//				System.out.println("监听到事件:"+event);
//			}
//			
//		});
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		System.out.println(defaultListableBeanFactory.getBeanDefinitionCount());
		ClassPathBeanDefinitionScanner scanner = 
				new ClassPathBeanDefinitionScanner(defaultListableBeanFactory);
		//scanner.addExcludeFilter(new AnnotationTypeFilter(Service.class));
		scanner.addIncludeFilter(new AnnotationTypeFilter(MyAnnotation.class));
		scanner.scan("com.source.analy.model");
//		int beanDefinitionCount = defaultListableBeanFactory.getBeanDefinitionCount();
//		System.out.println(beanDefinitionCount);
		List<String> asList = Arrays.asList(defaultListableBeanFactory.getBeanDefinitionNames());
		asList.forEach(a->{
			System.out.println(defaultListableBeanFactory.getBean(a).getClass());
		});
	}
}
