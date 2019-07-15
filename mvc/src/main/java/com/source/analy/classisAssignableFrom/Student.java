package com.source.analy.classisAssignableFrom;

public class Student implements Person{

	public static void main(String[] args) {
		Student student = new Student();
		Worker worker = new Worker();
		
		System.out.println(Person.class.isAssignableFrom(student.getClass()));
		System.out.println(Person.class.isAssignableFrom(worker.getClass()));
		System.out.println(Student.class.isAssignableFrom(worker.getClass()));
	}
}
