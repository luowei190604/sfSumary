package com.source.analy.factoryBean;

import com.source.analy.model.Car;

public class NormalCarFactoryBean {
	
	public Car getNormalCar(){
		Car car = new Car();
		car.setBeand("普通方法普通轿车");
		car.setMaxSpeed("120");
		car.setPrice(10.00);
		return car;
	}
	
	public static Car getStaticNormalCar(){
		Car car = new Car();
		car.setBeand("静态方法获得普通轿车");
		car.setMaxSpeed("120");
		car.setPrice(10.00);
		return car;
	}
}
