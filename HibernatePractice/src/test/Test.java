package test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		/*//Object
		Employee emp1 = new Employee(0, "a", new Date(), new Date());
		Employee emp2 = new Employee(0, "b", new Date(), new Date());
		Employee emp3 = new Employee(0, "c", new Date(), new Date());
		Employee emp4 = new Employee(0, "d", new Date(), new Date());
		Employee emp5 = new Employee(0, "e", new Date(), new Date());
		Employee emp6 = new Employee(0, "f", new Date(), new Date());
		Employee emp7 = new Employee(0, "g", new Date(), new Date());
		Employee emp8 = new Employee(0, "h", new Date(), new Date());
		Employee emp9 = new Employee(0, "i", new Date(), new Date());
		Employee emp10 = new Employee(0, "j", new Date(), new Date());
		Employee emp11 = new Employee(0, "k", new Date(), new Date());
		
		
		int i = (Integer)session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.save(emp7);
		session.save(emp8);
		session.save(emp9);
		session.save(emp10);
		session.save(emp11);
		
		System.out.println(i);
*/		
		t.commit();
		
		//List<Employee> emp = (List<Employee>)session.createQuery("from Employee").setFirstResult(5).setMaxResults(10).list();
		
		/*List<Employee> emp = (List<Employee>)session.createQuery("from Employee").list();
		System.out.println(emp);*/
		
		Employee employee = (Employee)session.get(Employee.class, 1);
		System.out.println(employee);
		
		Employee employee2 = (Employee)session.get(Employee.class, 1);
		System.out.println(employee2);
		
		Employee employee3 = (Employee)session.get(Employee.class, 1);
		System.out.println(employee3);
		
		Session session2 = sessionFactory.openSession();
		System.out.println(session2.get(Employee.class, 1));
		
		session.close();
		session2.close();
		sessionFactory.close();

	}

}
