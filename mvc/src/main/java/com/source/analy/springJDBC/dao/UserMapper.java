package com.source.analy.springJDBC.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.source.analy.springJDBC.model.User;

@Transactional
public interface UserMapper {

	public void saveUser(User u);
	
	List<User> selectByIds(List<Integer> ids);
	
	void batchSaveUser(List<User> list);
	
	void updateUserInfo(@Param("id")Integer id,@Param("name")String name);
}
