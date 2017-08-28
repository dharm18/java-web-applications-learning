package com.dharam.test.domain;

import org.springframework.beans.factory.FactoryBean;

public class BusFactory implements FactoryBean<ICar> {

	private String carName;
	
	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	@Override
	public ICar getObject() throws Exception {
		return (ICar) Class.forName(carName).newInstance();
	}
	
	
	@Override
	public Class<?> getObjectType() {
		
		return this.getClass();
	}
	
	
	@Override
	public boolean isSingleton() {
		return false;
	}
}
