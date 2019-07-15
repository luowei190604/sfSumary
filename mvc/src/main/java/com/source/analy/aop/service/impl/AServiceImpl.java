package com.source.analy.aop.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.source.analy.aop.service.AService;

public class AServiceImpl implements AService{

	@Transactional(propagation=Propagation.REQUIRED)
	public void a() {
		this.b();
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void b() {
		
	}

}
