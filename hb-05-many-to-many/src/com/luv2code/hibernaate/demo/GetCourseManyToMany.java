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

public class GetCourseManyToMany {
	
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
			
		
		Course tempCourse = new Course();
		Student tempStudent = new Student();
		//int number = session.createQuery("from Course where title='Tenis'")
		//		.getFirstResult();
		
		int number = 10;
		System.out.println("number is: " + number);
		
		tempCourse = session.get(Course.class, number);
		
		System.out.println("The course is: " + tempCourse);

		
		List result = session.createQuery("from Student where first_name = 'Malwina'")
				.getResultList();

		
		tempStudent = (Student) result.get(0);
		System.out.println("Student is: " + tempStudent);
		
		
		tempCourse.addStudent(tempStudent);
		
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
