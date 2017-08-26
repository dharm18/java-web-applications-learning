package com.dharam.test.domain;

import java.util.Arrays;

public class Car {

	private String[] carnames;
	private Engine[] engines;
	public String[] getCarnames() {
		return carnames;
	}
	public void setCarnames(String[] carnames) {
		this.carnames = carnames;
	}
	public Engine[] getEngines() {
		return engines;
	}
	public void setEngines(Engine[] engines) {
		this.engines = engines;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [carnames=");
		builder.append(Arrays.toString(carnames));
		builder.append(", engines=");
		builder.append(Arrays.toString(engines));
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
