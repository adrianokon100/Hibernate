package com.luv2code.hibernaate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {
	
	public static void main(String[] args) {
		
		
		// create session Factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
		session.beginTransaction();
			
		
		// create a course
		
		Course tempCourse = new Course("Squash for beginners");
		
		Review tempReview = new Review("It is a helpful course");
		Review tempReviewTwo = new Review("Now I can play more");		
		
		// add some reviews

		tempCourse.add(tempReview);
		tempCourse.add(tempReviewTwo);
	
		tempCourse.add(new Review("I don't like it"));

		/*
		for(int i=0; i < tempCourse.getReviews().size(); i++) {
			System.out.println("Revew: " + tempCourse.getReviews().get(i));
		}
		
		*/
		
		
		

		// save the cours ... and leverage the cascaded all :-)
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		session.save(tempCourse);
		
				
		
			
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
