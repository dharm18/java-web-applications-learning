package com.dharam.rockalltest.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class LoanAccount {
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("creditpolicy")
	private String creditPolicy;

	@SerializedName("amount")
	private double amount;
	
	@SerializedName("eligible_collateral")
	private double eligibleCollateral;
	
	@SerializedName("positions")
	private List<Position> positions;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCreditPolicy() {
		return creditPolicy;
	}
	public void setCreditPolicy(String creditPolicy) {
		this.creditPolicy = creditPolicy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public double getEligibleCollateral() {
		return eligibleCollateral;
	}
	public void setEligibleCollateral(double eligibleCollateral) {
		this.eligibleCollateral = eligibleCollateral;
	}
	
	
	

}
