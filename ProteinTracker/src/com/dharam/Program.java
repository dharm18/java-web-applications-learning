package com.dharam;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Program {

	public static void main(String[] args) {
		System.out.println("Protein Tracker App is Startting...");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.getHistory().add(new UserHistory(new Date(), "Set name to Joe"));
		user.setName("Joe");
		user.getProteinData().setTotal(0);
		user.getProteinData().setGoal(250);
		user.getHistory().add(new UserHistory(new Date(), "Set the goal to 250"));
		session.save(user);
		transaction.commit();
		
		session.beginTransaction();
		User loadedUser = (User)session.get(User.class, 1);
		System.out.println(loadedUser);
		
		loadedUser.getProteinData().setTotal(50);
		user.getHistory().add(new UserHistory(new Date(), "Set the total to 50"));
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
