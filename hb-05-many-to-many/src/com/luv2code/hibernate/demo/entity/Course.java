package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.NA;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name="course")
public class Course {
	
	// annotate the class as an entity and map to db table
	
	// define fields
		
	// annotate the fields with db column names
		
	// ** set up mapping  to InstructorDetail entity
	// create constructors
		
	// generate getter/setter methods
		
	// generate toString() method

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	

	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

	
	// Annotation - many to many: course can have a lot of students
	// Table between Course and Student (many to many)	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")			
			)
	private List<Student> students;
	
	
	
	public Course() {
		
	}
	
	public Course(String title) {
		this.title = title;
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void add(Review tempReview) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(tempReview);
		//tempReview.setCourseId(this);
	}
	
	
	public void addStudent(Student tempStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(tempStudent);
		
		//czemu nie ma tego
		//tempStudent.add(this);
		
	}
	
	
	
	
	
	
}
