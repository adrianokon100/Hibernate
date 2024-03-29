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

public class AddCoursesForMaryDemo {
	
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
			
		int id = 18;
		
		Student tempStudent = new Student();
		tempStudent = session.get(Student.class, id);
		
		System.out.println("I tokk this student: " + tempStudent);
		
		
		Course tempCourse1 = new Course("Psychology");
		session.save(tempCourse1);
		//Course tempCiurse2 = new Course("New Balance");
		
		tempStudent.addCourse(tempCourse1);
		
		
		
		
		
		
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
