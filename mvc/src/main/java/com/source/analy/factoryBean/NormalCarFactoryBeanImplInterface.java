package com.source.analy.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import com.source.analy.model.Car;

public class NormalCarFactoryBeanImplInterface implements FactoryBean<Car>{

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		car.setBeand("实现FactoryBean返回汽车对象");
		car.setMaxSpeed("120");
		car.setPrice(10.00);
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}
