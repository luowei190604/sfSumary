package com.source.analy.diyBeanPostProcessor;

import java.lang.annotation.Annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.source.analy.diyAnnotation.DiyComponentAnnotation;

public class DiyFirstBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("处理器调用before方法"+beanName);
//		Annotation[] annotations = bean.getClass().getAnnotations();
//		
//		for(Annotation an:annotations){
//			if(an.annotationType().toString().equals("com.source.analy.diyAnnotation.DiyComponentAnnotation")){
//				System.out.println("第一个注解被监测到了");
//			}
//		}
		boolean annotationPresent = bean.getClass().isAnnotationPresent(DiyComponentAnnotation.class);
		if(annotationPresent){
			System.out.println("第一个注解被监测到了");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("处理器调用after方法"+beanName);
		return bean;
	}

}
