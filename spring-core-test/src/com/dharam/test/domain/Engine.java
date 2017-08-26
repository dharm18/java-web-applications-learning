package com.dharam.test.domain;

public class Engine {

	private String modelYear;

	public Engine(){
		
	}
	
	public Engine(String modelYear) {
		super();
		this.modelYear = modelYear;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Engine [modelYear=");
		builder.append(modelYear);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
