package com.test.calculator;

public class UnitCalculator implements IUnitCalculator {

	@Override
	public double kilogramToPound(double kilogram) {
		double pound = kilogram * 2.2;
		System.out.println(kilogram + " kilogram = " + pound + " pound");
		return pound;
	}

	@Override
	public double kilometerToMile(double kilometer) {
		double mile = kilometer * 0.62;
		System.out.println(kilometer + " kilometer = " + mile + " mile");
		return mile;
	}

}
