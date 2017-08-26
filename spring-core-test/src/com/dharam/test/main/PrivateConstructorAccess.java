package com.dharam.test.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrivateConstructorAccess {

	public static void main(String[] args) {
		
		try {
			Class c = Class.forName("com.dharam.test.domain.Employee");
			Constructor con[] = c.getDeclaredConstructors();
			con[0].setAccessible(true);
			con[0].newInstance(null);
			//c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
