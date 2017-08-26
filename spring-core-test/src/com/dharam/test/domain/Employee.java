package com.dharam.test.domain;

public class Employee {

	private String name;
	private int age;
	private String email;
	private Address address;
	/*private Employee(){
		System.out.println("employee object creation");
	}*/
	public Employee(){
		
	}
	public Employee(String name){
		this.name = name;
	}
	
	public Employee(int age){
		this.age = age;
	}
	public Employee(String name,int age){
		this.name = name;
		this.age = age;
	}
	public Employee(String name,int age,String email){
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", email=");
		builder.append(email);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	
	
}
