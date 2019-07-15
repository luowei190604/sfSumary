package com.source.analy.aop.model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..) )")
	public void test(){
		
	}
	
	@Before("test()")
	public void beforeTest(){
		System.out.println("before test");
	}
	
	@After("test()")
	public void afterTest(){
		System.out.println("after test");
	}
	
	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p){
		System.out.println("before1");
		Object o=null;
		try{
			o=p.proceed();
		}catch(Throwable t){
			t.printStackTrace();
		}
		System.out.println("after1");
		return o;
	}
}
