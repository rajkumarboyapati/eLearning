package com.demo.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	private String courseName;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employeeRef;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Instructor> instructorRef;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Modules> moduleList;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Level> levelList;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	private int courseDuration;
	public Course() {}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Employee> getEmployeeRef() {
		return employeeRef;
	}
	public void setEmployeeRef(List<Employee> employeeRef) {
		this.employeeRef = employeeRef;
	}
	public List<Instructor> getInstructorRef() {
		return instructorRef;
	}
	public void setInstructorRef(List<Instructor> instructorRef) {
		this.instructorRef = instructorRef;
	}
	public List<Modules> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Modules> moduleList) {
		this.moduleList = moduleList;
	}
	public List<Level> getLevelList() {
		return levelList;
	}
	public void setLevelList(List<Level> levelList) {
		this.levelList = levelList;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public Course(int courseId, String courseName, List<Employee> employeeRef, List<Instructor> instructorRef,
			List<Modules> moduleList, List<Level> levelList, Category category, int courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.employeeRef = employeeRef;
		this.instructorRef = instructorRef;
		this.moduleList = moduleList;
		this.levelList = levelList;
		this.category = category;
		this.courseDuration = courseDuration;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", employeeRef=" + employeeRef
				+ ", instructorRef=" + instructorRef + ", moduleList=" + moduleList + ", levelList=" + levelList
				+ ", category=" + category + ", courseDuration=" + courseDuration + "]";
	}
	

	
	
	
	
	
	
	

}
