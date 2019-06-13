package com.luv2code.hibernate.demo;
 
import java.text.ParseException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
  
public class CreateCoursesDemoAgain {
 
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
     
    	
    	    // get the instructor from db
        	  
            // start transaction
      		session.beginTransaction();
        	
        	
        	int id = 1;
        	Instructor tempInstructor = session.get(Instructor.class, id);

        	
        	// create some courses
        	
        	Course courseAboutMexico = new Course("Mexico");
        	Course courseAboutVietnam = new Course("Vietnam");

        	// add courses to instructor

        	tempInstructor.add(courseAboutMexico);
        	tempInstructor.add(courseAboutVietnam);
        	
        	

        	// save the courses
        	
        	session.save(courseAboutMexico);
        	session.save(courseAboutVietnam);
            
  

            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("DoneSecond!");
            
        } finally {
        	
        	// add clean up code
        	
        	session.close();
            factory.close();
        }
    }
    
}