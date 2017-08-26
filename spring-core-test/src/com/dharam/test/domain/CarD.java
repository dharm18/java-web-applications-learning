package com.dharam.test.domain;

import org.springframework.beans.factory.annotation.Required;

public class CarD {

	private String carName;
	private Engine engine;
	public String getCarName() {
		return carName;
	}
	
	public CarD(){
		
	}
	
	public CarD(Engine engine) {
		super();
		this.engine = engine;
		System.out.println("using constructor engine");
	}


	@Required
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
		System.out.println("using setter engine");
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarD [carName=");
		builder.append(carName);
		builder.append(", engine=");
		builder.append(engine);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
