package com.demo.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Reports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;
	
	private double progress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseRef;
	private int quizId;
	private int quizScore;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Course getCourseRef() {
		return courseRef;
	}
	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getQuizScore() {
		return quizScore;
	}
	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}
	public Reports(int reportId, double progress, Employee employee, Course courseRef, int quizId, int quizScore) {
		super();
		this.reportId = reportId;
		this.progress = progress;
		this.employee = employee;
		this.courseRef = courseRef;
		this.quizId = quizId;
		this.quizScore = quizScore;
	}
	public Reports() {
		super();
	}
	@Override
	public String toString() {
		return "Reports [reportId=" + reportId + ", progress=" + progress + ", employee=" + employee + ", courseRef="
				+ courseRef + ", quizId=" + quizId + ", quizScore=" + quizScore + "]";
	}
	
	
	
	
	
	

}
