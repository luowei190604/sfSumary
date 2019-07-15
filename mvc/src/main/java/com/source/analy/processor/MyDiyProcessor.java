package com.source.analy.processor;

import java.lang.annotation.Annotation;
import java.util.Objects;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.source.analy.annotation.MyAnnotation;
import com.source.analy.cglib.CglibProxy;
import com.source.analy.model.Car;

public class MyDiyProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		Annotation[] annotations = bean.getClass().getAnnotations();
//		for(Annotation a:annotations){
//			a.
//		}
//		if(bean instanceof Car){
//			Class<? extends Object> cl = bean.getClass();
////			Annotation[] annotations = cl.getAnnotations();
////			for(Annotation a:annotations){
////				Class<? extends Annotation> annotationType = a.annotationType();
////				if(annotationType==MyAnnotation.class){
////					System.out.println("haha");
////				}
////				System.out.println(a);
////			}
//			MyAnnotation annotation = cl.getAnnotation(MyAnnotation.class);
//		}
		Class<? extends Object> cl = bean.getClass();
		MyAnnotation annotation = cl.getAnnotation(MyAnnotation.class);
		if(!Objects.isNull(annotation)){
			CglibProxy proxy = new CglibProxy();
			return proxy.getProxy(bean.getClass());
		}
		//System.out.println("前置处理器处理bean名称是:"+bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println("后置处理器处理bean名称是:"+bean);
		return bean;
	}
	
}
