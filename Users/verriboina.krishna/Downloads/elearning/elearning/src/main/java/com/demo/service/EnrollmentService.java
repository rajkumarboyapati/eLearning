package com.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Course;
import com.demo.entities.Employee;
import com.demo.entities.Enrollment;
import com.demo.repository.CourseRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.EnrollmentRepository;
@Service
public class EnrollmentService implements IEnrollmentService {
@Autowired
private EnrollmentRepository enrollmentRepository;
@Autowired
private EmployeeRepository employeeRepository;
@Autowired
private CourseRepository courseRepository;
	@Override
	public Enrollment addEnrollment(Enrollment enrollment) {
		
		return enrollmentRepository.save(enrollment);
	}

	@Override
	public Enrollment getEnrollment(int enrollMentId) {
		// TODO Auto-generated method stub
		return enrollmentRepository.findById(enrollMentId).get();
	}

	@Override
	public List<Enrollment> getAllEnrollments() {
		// TODO Auto-generated method stub
		return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment deleteEnrollment(int enrollmentId) {
		Enrollment enrollment=enrollmentRepository.findById(enrollmentId).get();
		if(enrollment!=null) {
			enrollmentRepository.delete(enrollment);
		}
		return enrollment;
	}

	@Override
	public Enrollment addEnrollment1( int courseId, int employeeId) {
		List<Course> course1=courseRepository.getAllCourses(courseId);
		Employee employee1=employeeRepository.findById(employeeId).get();
		Enrollment enrollment=new Enrollment();
		enrollment.setCourseRef(course1);
		enrollment.setDate(LocalDate.now());
		enrollment.setEmployeeRef(employee1);
		enrollmentRepository.save(enrollment);
		return enrollment;
	}

}
