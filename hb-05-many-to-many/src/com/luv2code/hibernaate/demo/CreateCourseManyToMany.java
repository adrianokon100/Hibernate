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

public class CreateCourseManyToMany {
	
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
			
		
		
		Course tempCourse = new Course("Alpinist");		
		
		session.save(tempCourse);
		System.out.println("Saved the course");
		
		// create students
		
		Student tempStudent1 = new Student("Ania", "Freak", "freak@gmail.com");
		Student tempStudent2 = new Student("Ula", "Satelman", "ula@gmail.com");

		// add students to the course
		
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		
		// save the students
		System.out.println("\n Saving students ... ll");
		session.save(tempStudent1);
		session.save(tempStudent2);
		System.out.println("\n Saved students: " + tempCourse.getStudents());

		

		//session.persist(tempCourse);
		//session.save(tempCourse);
		
		
		
		
		
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
