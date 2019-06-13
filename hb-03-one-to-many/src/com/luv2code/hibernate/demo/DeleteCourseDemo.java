package com.luv2code.hibernate.demo;
 
import java.text.ParseException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
  
public class DeleteCourseDemo {
 
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
        	
            int id=4;
            
           session.beginTransaction();
            
            Instructor tempInstructor = new Instructor();
            tempInstructor = session.get(Instructor.class, id);
            System.out.println("I retrieved this instructor: " + tempInstructor);

           
            Course tempCourse = new Course();
            
            /*for(int i=0; i<tempInstructor.getCourses().size(); i++) {
                System.out.println("Number of courses: " + tempInstructor.getCourses().size());

                //tempCourse = tempInstructor.getCourses().get(i);
                //System.out.println("I retrieved this course: " + tempCourse);

                tempInstructor.getCourses().get(i).setInstructor(null);
                //tempCourse.setInstructor(null);
            
            }*/
            

            
           //session.delete(tempInstructor);
            session.createQuery("DELETE FROM Instructor WHERE id=4").executeUpdate();
            
        	/*session.beginTransaction();
        	
        	int id = 17;
        	Course tempCourse = session.get(Course.class, id);
        	System.out.println("I retrieved: " + tempCourse);
        	
            //session.createQuery("DELETE FROM Instructor where id=6").executeUpdate();
        	
        	System.out.println("I will delete: ...");
        	session.delete(tempCourse);
        	
        	//session.createQuery("Delete from Course where id=20").
        	//executeUpdate();
        	//System.out.println("Deleted");

*/
            
            
            // commit trnsaction
            session.getTransaction();
            System.out.println("Done too!");
            
            
            
            
        } finally {
        	session.close();
            factory.close();
        }
    }

	
}