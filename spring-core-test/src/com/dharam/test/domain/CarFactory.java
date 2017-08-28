package com.dharam.test.domain;

public class CarFactory {

	/*private static String carName;
	
	public static void setCarName(String carName){
		CarFactory.carName = carName;
	}*/
	
	private String carName;
	
	
	public String getCarName() {
		return carName;
	}



	public void setCarName(String carName) {
		this.carName = carName;
	}



	public ICar getInstance() throws Exception{
		return (ICar)Class.forName(carName).newInstance();
	}
	
}
