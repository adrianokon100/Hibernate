package com.luv2code.hibernate.demo;
 
import java.text.ParseException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
  
public class CreateCoursesDemo {
 
    public static void main(String[] args) {
        
        // create session factory
        SessionFactory factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Instructor.class)
        		.addAnnotatedClass(InstructorDetail.class)
        		.addAnnotatedClass(Course.class)
                .buildSessionFactory();
 
        // create a session
        Session session = factory.getCurrentSession();
 
        try {
        	
        	// Create the objects
        	
        	            
    		Instructor tempInstructor = 
        			new Instructor("RichardAgain", "FaynmannAgain", "feynmann@luv2code.com");

    		//InstructorDetail tempInstructorDetail =
    				//new InstructorDetail("http://www.youtube.com", "Physik!");
    		
    		Course tempCourse = new Course("PsychologyYoung");
    		Course tempCourse2 = new Course("PhilosophyYoung");
    		Course tempCourse3 = new Course("PhysikYoung");

    		
    		
    	      
        	
        	// associate the objects
    		//tempInstructor.setInstructorDetail(tempInstructorDetail);
            tempCourse.setInstructor(tempInstructor);
            tempCourse2.setInstructor(tempInstructor);
            tempCourse3.setInstructor(tempInstructor);
            // start transaction

    		session.beginTransaction();
 
            // save a transaction
    		
    		session.persist(tempCourse);
    		session.persist(tempCourse2);
    		session.persist(tempCourse3);

            System.out.println("Saving course: " + tempCourse);
            session.save(tempCourse);

            System.out.println("Saving course: " + tempCourse2);
            session.save(tempCourse2);

            System.out.println("Saving course: " + tempCourse3);
            session.save(tempCourse3);

            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
            
        } finally {
        	
        	// add clean up code
        	
        	session.close();
            factory.close();
        }
    }
    
}