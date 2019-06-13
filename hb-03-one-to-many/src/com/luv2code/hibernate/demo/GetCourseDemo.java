package com.luv2code.hibernate.demo;
 
import java.text.ParseException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
  
public class GetCourseDemo {
 
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
        	
           // int id=13;
        	
        	// start transaction
          /*  session.beginTransaction();
          
            Course tempCourse = session.get(Course.class, id);
            System.out.println("I retrieved course: " + tempCourse);
            System.out.println("Instructor of this course is: " + tempCourse.getInstructor());
            System.out.println("Details about instructor: " + tempCourse.getInstructor().getInstructorDetail());
            
            
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done! \n");
            */
            // Second part - I will take courses of instructor
            
            // start session
            
            session.beginTransaction();
            
            int id2 = 10;
            Instructor tempInstructor = session.get(Instructor.class, id2);
            
            System.out.println("The instructor: " + tempInstructor.getFirstName() + " " + tempInstructor.getLastName()
            + " " + "has these courses: ");
            
            Course tempCourse = new Course();
            
            for(int i = 0; i<tempInstructor.getCourses().size(); i++) {
            	tempCourse = tempInstructor.getCourses().get(i);
            	System.out.println(tempCourse.getTitle());
            
            }
            
            
            // commit trnsaction
            session.getTransaction();
            System.out.println("Done too!");
            
        } finally {
            factory.close();
        }
    }

	
}