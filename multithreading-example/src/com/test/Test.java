package com.test;

public class Test {

	public static void main(String[] args) {
	
		String name = "Dhar hhh hhh";
		//String name = "Dharm";
		String[] splitedName = name.split("\\s+");
		String firstName = name;
		String lastName = "-";
		if(splitedName.length > 1){
			
			lastName = splitedName[splitedName.length - 1];
			firstName = "";
			for (int i = 0; i < splitedName.length-1; i++) {
				firstName += splitedName[i];
			}
		}
		
		
		System.out.println(firstName);
		System.out.println(lastName);
	}
	
	
}
