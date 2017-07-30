package com.dharam.elearning.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dharam.elearning.domain.Course;

@Repository
@Transactional
public class CourseDao implements ICourseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public Session getSession(){
		
		try{
			session = sessionFactory.getCurrentSession();
		}
		catch(Exception ex){
			//ex.printStackTrace();
			session = sessionFactory.openSession();
		}
		
		return session;
	}
	
	
	@Override
	public List<Course> findAllCourses() {
		return getSession().createCriteria(Course.class).list();
	}
	
	@Override
	public List<Course> findAllCourses(int page, int size) {
		return getSession().createCriteria(Course.class).setMaxResults(size).setFirstResult(page).list();
	}

	@Override
	public boolean addCourse(Course course) {
		return (long)getSession().save(course) > 0;
	}


	@Override
	public Course getCourse(long id) {
		return getSession().get(Course.class, id);
	}
	
	@Override
	public void deleteCourse(long id) {
		Session session = getSession();
		Course course = session.load(Course.class, id);
		session.delete(course);
		session.flush();
	}
	
	@Override
	public void updateCourse(Course course) {
		Session session = getSession();
		session.merge(course);
		session.flush();
	}
	

}
