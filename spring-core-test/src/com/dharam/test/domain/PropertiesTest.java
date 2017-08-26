package com.dharam.test.domain;

import java.util.Properties;

public class PropertiesTest {

	private Properties driver;

	public Properties getDriver() {
		return driver;
	}

	public void setDriver(Properties driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertiesTest [driver=");
		builder.append(driver);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
