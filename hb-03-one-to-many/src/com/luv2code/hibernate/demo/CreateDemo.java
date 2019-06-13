package com.luv2code.hibernate.demo;
 
import java.text.ParseException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
  
public class CreateDemo {
 
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
        	
        	// Create the objects
        	
        	Instructor tempInstructor = 
        			new Instructor("NoYea", "Darby", "darby@luv2codeNoY.com");

    		InstructorDetail tempInstructorDetail =
    				new InstructorDetail("http://www.luv2code.com/youtubeNoY", "Luv 2 code");
    	        	
        	
            session.beginTransaction();
            /*
    		Instructor tempInstructor = 
        			new Instructor("Madhu", "Patel", "madu@luv2code.com");

    		InstructorDetail tempInstructorDetail =
    				new InstructorDetail("http://www.youtube.com", "Guitar");
    		
    		*/
    	        	
        	// associate the objects
    		//tempInstructor.setInstructorDetail(tempInstructorDetail);
            tempInstructorDetail.setInstructor(tempInstructor);
            
        	//tempInstructorDetail.getInstructor().setInstructorDetail(tempInstructorDetail);  
        	//session.persist(tempInstructor);
            
            
            // start transaction
 
            // save a transaction
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.All
            //
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructorDetail);
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
            
        } finally {
            factory.close();
        }
    }
    
}