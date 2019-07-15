package com.source.analy.springJDBC.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

	
	void updateUserInfo(Integer id,String name);
}
