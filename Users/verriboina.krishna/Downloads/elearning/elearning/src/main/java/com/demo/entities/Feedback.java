package com.demo.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	
	private String feedbackName;
	
	private String feedbackContent;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Course courseRef;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employeeRef;
	
	public Feedback() {}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackName() {
		return feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public Course getCourseRef() {
		return courseRef;
	}

	public void setCourseRef(Course courseRef) {
		this.courseRef = courseRef;
	}

	public Employee getEmployeeRef() {
		return employeeRef;
	}

	public void setEmployeeRef(Employee employeeRef) {
		this.employeeRef = employeeRef;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackName=" + feedbackName + ", feedbackContent="
				+ feedbackContent + ", courseRef=" + courseRef + ", employeeRef=" + employeeRef + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseRef, employeeRef, feedbackContent, feedbackId, feedbackName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(courseRef, other.courseRef) && Objects.equals(employeeRef, other.employeeRef)
				&& Objects.equals(feedbackContent, other.feedbackContent) && feedbackId == other.feedbackId
				&& Objects.equals(feedbackName, other.feedbackName);
	}

	
}
