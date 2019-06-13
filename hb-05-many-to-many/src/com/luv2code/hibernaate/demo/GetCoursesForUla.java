package com.luv2code.hibernaate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCoursesForUla {
	
	public static void main(String[] args) {
		
		
		// create session Factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
		session.beginTransaction();
			
		
		Student tempStudent = new Student();
		
		
		List result = session.createQuery("FROM Student where firstName='Ania'").getResultList();
	
		tempStudent = (Student) result.get(0);
		
		System.out.println("I took student: " + tempStudent);
		
		System.out.println("Courses: " + tempStudent.getCourses());

		
	
		
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
