package com.source.analy.springJDBC.model;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4313016543020064033L;

	private int id;
	
	private String name;
	
//	private int age;
//	
//	private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name="+this.getName()+"id="+this.id;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
	
	
}
