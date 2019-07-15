package com.source.analy;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationContextStarter {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//		System.out.println("注册之前个数:"+context.getBeanFactory().getBeanDefinitionCount());
//		context.register(AnnotationContextStarter.class);
		
		
		
		ApplicationListener<ApplicationEvent> listener = new ApplicationListener<ApplicationEvent>() {

			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				if(event instanceof DiyEvent){
					System.out.println("接收到事件");
					System.out.println("接收到的数据是:"+event.getSource());
				}
			}
			
		};
		
		//context.registerBeanDefinition(beanName, beanDefinition);
		context.addApplicationListener(listener);
		context.refresh();
		context.publishEvent(new DiyEvent("hello"));
//		System.out.println("注册之后个数:"+context.getBeanFactory().getBeanDefinitionCount());
//		System.out.println(context.getBean(AnnotationContextStarter.class));
	}
}
class DiyEvent extends ApplicationEvent{

	public DiyEvent(Object source) {
		super(source);
	}
	
}
