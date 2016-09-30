package com.dharam.elearning.user.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.dharam.elearning.generic.bean.GenericBean;

public class User extends GenericBean {

	@NotNull
	@Size(min = 4)
	private String code;
	
	@NotNull
	@Size(min = 4,max=10)
	private String name;
	
	private String description;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}
