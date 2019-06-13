package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		
		
		 // create session factory
        SessionFactory factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
 
        // create a session
        Session session = factory.getCurrentSession();
        
        try {
        	
        	
        	// I get object
        	session.beginTransaction();
/*
        	Instructor instructor = new Instructor();
        	
        	instructor = session.get(Instructor.class, 4);
        	System.out.println("I get this object: " + instructor);
        	
        	session.getTransaction().commit();
 */       	
        	// NEW SESSION
        	
        	//session = factory.getCurrentSession();
        	//session.beginTransaction();
        	
        	//session.delete(instructor);
        	
        	
        	session.createQuery("delete FROM Instructor where id=1").executeUpdate();
        	System.out.println("Deleted");
        	
        	
        	session.getTransaction().commit();
        	System.out.println("Done!");
        	
        	
			
		} finally {
			factory.close();
		}
	}

}
