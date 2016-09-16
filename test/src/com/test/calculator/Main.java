package com.test.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		IArithmeticCalculator arithmeticCalculator = (IArithmeticCalculator) context.getBean("arithmeticCalculator");
		arithmeticCalculator.add(1, 2);
		arithmeticCalculator.sub(4, 3);
		arithmeticCalculator.mul(2, 3);
		arithmeticCalculator.div(4, 2);
		
		IUnitCalculator unitCalculator = (IUnitCalculator) context.getBean("unitCalculator");
		
		unitCalculator.kilogramToPound(10);
		unitCalculator.kilometerToMile(5);
	}
}
