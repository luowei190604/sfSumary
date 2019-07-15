package com.source.analy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import com.source.analy.aop.model.TestBean;
import com.source.analy.circleDependceModel.TestA;
import com.source.analy.circleDependceModel.TestB;
import com.source.analy.diyAnnotation.DiyPojo;
import com.source.analy.diyBeanPostProcessor.DiyFirstBeanPostProcessor;
import com.source.analy.model.Car;
import com.source.analy.model.User;
import com.source.analy.mvc.controller.TestCgLibAndDiyAnnotation;
import com.source.analy.springJDBC.dao.UserMapper;
import com.source.analy.springJDBC.service.UserService;

@SuppressWarnings("deprecation")
public class Starter {
	
	public static Map<Integer,String> configXml=new HashMap<>();
	
	static{
		configXml.put(1, "applicationContext.xml");
		configXml.put(2, "spring-aop.xml");
		configXml.put(3, "diyApplication.xml");
		configXml.put(4, "spring-dataSource.xml");
		configXml.put(5, "spring-context.xml");
		configXml.put(6, "applicationContext-tx.xml");
	}
	
	@SuppressWarnings({ "deprecation", "resource", "unused" })
	public static void main(String[] args) throws ClassNotFoundException {
		String configName="";
		String beanName="";
		String beanClass="";
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String str = reader.readLine();
			String[] split = str.split(",");
			configName=configXml.get(Integer.parseInt(split[0]));
			//beanName=split[1];
			//beanClass=split[2];
		}catch(Exception e){
			e.printStackTrace();
		}
//		XmlBeanFactory crt = new XmlBeanFactory(new ClassPathResource(configName));
//		crt.addBeanPostProcessor(new DiyFirstBeanPostProcessor() );
		ClassPathXmlApplicationContext crt = new ClassPathXmlApplicationContext(configName);
		/*User user = (User)crt.getBean("user");*/
//		System.out.println(user.getP());
//		Person person = (Person)ReflectUtils.newInstance(Class.forName("com.source.analy.model.Person"));
//		person.doKafkamessage();
//		User u = (User)xmlBeanFactory.getBean("custom");
//		System.out.println(u.getName());
//		
//		Car car=(Car)crt.getBean("car");
//		System.out.println(car.getMaxSpeed());
//		
//		Object factoryBean = crt.getBean("&car");
//		System.out.println(factoryBean.getClass());
		
//		Car normalCar=(Car)crt.getBean("normalCar");
//		System.out.println("普通轿车名称是:"+normalCar.getBeand());
//		
//		Car normalStaticCar=(Car)crt.getBean("normalStaticCar");
//		System.out.println("普通轿车名称是:"+normalStaticCar.getBeand());
		
//		xmlBeanFactory.setAllowCircularReferences(false);
//		TestA testa = (TestA)crt.getBean("testa");
//		System.out.println(testa.getTestb().toString());
//		
//		TestB testb = (TestB)crt.getBean("testb");
//		System.out.println(testb.toString());
//		Car bean = (Car)crt.getBean("normalStaticCar");
//		System.out.println(.toString());
		
//		User user = (User)crt.getBean("user");
//		System.out.println(user);
		//DiyFirstBeanPostProcessor testBean=(DiyFirstBeanPostProcessor)crt.getBean("diyFirstBeanPostProcessor");
		//DiyPojo bean =(DiyPojo) crt.getBean("diyPojo");
//		bean.test();
		
		//UserMapper
		//Executors.newFixedThreadPool(10);
		
//		Car bean = (Car)crt.getBean("normalStaticCar");
		//TestCgLibAndDiyAnnotation tld=(TestCgLibAndDiyAnnotation)crt.getBean("testCgLibAndDiyAnnotation");
//		bean.sayhello();
		//tld.say();
		UserService service = (UserService) crt.getBean(UserService.class);
//		System.out.println(crt.getBeanDefinitionCount());
		service.updateUserInfo(1, "李斯");
//		com.source.analy.springJDBC.controller.TestController bean = crt.getBean(com.source.analy.springJDBC.controller.TestController.class);
//		System.out.println(bean);
	}
}
