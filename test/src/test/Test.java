package test;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(
				"beans.xml");
		Product aaa = (Product) context.getBean("aaa");
		Product cdrw = (Product) context.getBean("cdrw");
		Product dvdrw = (Product) context.getBean("dvdrw");
		ShoppingCart cart1 = (ShoppingCart) context.getBean("shoppingCart");
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		System.out.println("Shopping cart 1 contains " + cart1.getItems());
		ShoppingCart cart2 = (ShoppingCart) context.getBean("shoppingCart");
		cart2.addItem(dvdrw);
		System.out.println("Shopping cart 2 contains " + cart2.getItems());
		
		//i18n message display
		String alert = context.getMessage("alert.checkout", null, Locale.US);
		System.out.println(alert);
		
		 alert = context.getMessage("alert.inventory.checkout",new Object[] { 4, new Date() }, Locale.US);
		 System.out.println(alert);
		 
		 Cashier cashier = (Cashier)context.getBean("cashier");
		 try {
			cashier.checkout(cart2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
