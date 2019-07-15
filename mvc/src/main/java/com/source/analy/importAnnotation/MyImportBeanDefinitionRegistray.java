package com.source.analy.importAnnotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

@Import({ImportRegistrarBean.class})
public class MyImportBeanDefinitionRegistray /*implements ImportBeanDefinitionRegistrar*/{

//	@Override
//	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ImportRegistrarBean.class);
//		registry.registerBeanDefinition("importDemo",rootBeanDefinition);
//	}


}
