package com.dharam.rockalltest.domain;

import com.google.gson.annotations.SerializedName;

public class Position {

	@SerializedName("id")
	private String id;
	
	@SerializedName("quantity")
	private long quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
