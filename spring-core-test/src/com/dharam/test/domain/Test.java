package com.dharam.test.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	private List fruits;
	private Set cricketers;
	private Map cc;
	public List getFruits() {
		return fruits;
	}
	public void setFruits(List fruits) {
		this.fruits = fruits;
	}
	public Set getCricketers() {
		return cricketers;
	}
	public void setCricketers(Set cricketers) {
		this.cricketers = cricketers;
	}
	public Map getCc() {
		return cc;
	}
	public void setCc(Map cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [fruits=");
		builder.append(fruits);
		builder.append(", cricketers=");
		builder.append(cricketers);
		builder.append(", cc=");
		builder.append(cc);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
