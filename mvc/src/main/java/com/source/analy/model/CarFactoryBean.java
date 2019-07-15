package com.source.analy.model;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car>{

	private String carInfo;

	public Car getObject() throws Exception {
		Car car = new Car();
		String[] info = carInfo.split(",");
		car.setBeand(info[0]);
		car.setMaxSpeed(info[1]);
		car.setPrice(Double.parseDouble(info[2]));
		return car;
	}

	public Class<?> getObjectType() {
		return Car.class;
	}

	public boolean isSingleton() {
		return false;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

}
