package com.source.analy;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import com.source.analy.importAnnotation.ImportRegistrarBean;
import com.source.analy.importAnnotation.MyImportBeanDefinitionRegistray;

@Import({MyImportBeanDefinitionRegistray.class})
public class AnnotationContextStarterSecond {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MyImportBeanDefinitionRegistray.class);
		context.registerBeanDefinition("diyRegistry", rootBeanDefinition);
		context.refresh();
		//System.out.println(context.getBeanDefinitionCount());
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String name:beanDefinitionNames){
			//System.out.print(name+"--->");
			System.out.println(context.getBean(name).getClass());
		}
		System.out.println();
	}

}
