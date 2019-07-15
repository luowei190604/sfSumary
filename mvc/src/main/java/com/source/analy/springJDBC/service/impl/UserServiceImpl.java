package com.source.analy.springJDBC.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.analy.springJDBC.dao.UserMapper;
import com.source.analy.springJDBC.model.User;
import com.source.analy.springJDBC.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;

	@SuppressWarnings("resource")
	@Override
	public void updateUserInfo(Integer id, String name)  {
		//mapper.updateUserInfo(id, name);
		try{
			User user = new User();
			user.setId(id);
			user.setName(name);
			FileOutputStream fos = new FileOutputStream("D://a.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
			System.out.println(1/0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		FileInputStream  fis= new FileInputStream("D://a.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User readObject = (User)ois.readObject();
		System.out.println(readObject);
	}
	
}
