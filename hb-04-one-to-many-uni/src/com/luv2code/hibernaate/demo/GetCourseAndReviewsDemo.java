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

public class GetCourseAndReviewsDemo {
	
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
			
		
		int theiD = 10;		
		Course tempCourse = session.get(Course.class, theiD);
		
		
		System.out.println("I took this course");
		System.out.println(tempCourse);
		System.out.println(" \nReviews");
		
		List<Review> reviews = new ArrayList<>();
		reviews = tempCourse.getReviews();
		
		for(int i=0; i<reviews.size(); i++) {
		
			System.out.println(reviews.get(i).getComment());
		
		}
				
		
			
		session.getTransaction().commit();
		System.out.println("Done!");
			
			
				
		} finally {
			
			session.close();
			factory.close();
			
			
		}
		
		
	
				
		
		
		
		
		
		
		
	}

}
