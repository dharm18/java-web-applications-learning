package com.dharam.test.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class ReqdCollection {

	private Vector fruits;
	private TreeSet cricketers;
	private HashMap cc;

	public List getFruits() {
		return fruits;
	}

	public void setFruits(Vector fruits) {
		this.fruits = fruits;
	}

	public void setCricketers(TreeSet cricketers) {
		this.cricketers = cricketers;
	}

	public void setCc(HashMap cc) {
		this.cc = cc;
	}

	

	public Set getCricketers() {
		return cricketers;
	}

	

	public Map getCc() {
		return cc;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReqdCollection [fruits=");
		builder.append(fruits);
		builder.append(", cricketers=");
		builder.append(cricketers);
		builder.append(", cc=");
		builder.append(cc);
		builder.append("]");
		return builder.toString();
	}

}
