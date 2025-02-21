package com.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.demo.entities.Enrollment;

public interface IEnrollmentService {
public Enrollment addEnrollment(Enrollment enrollment);
public Enrollment getEnrollment(int enrollMentId);
public List<Enrollment> getAllEnrollments();
public Enrollment deleteEnrollment(int enrollmentId);
public Enrollment addEnrollment1(int courseId,int employeeId);

}
