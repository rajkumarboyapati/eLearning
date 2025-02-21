package com.demo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Course;
import com.demo.entities.Material;
import com.demo.entities.Modules;

public interface ICourseService {
	public Course addCourse(Course course);
	public Course deleteCourse(int courseId);
	public Course updateCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourseById(int courseId);
	public Course getCourseByLevelAndCategory(String categoryName,String levelName);
	public Course getCourseByLevelAndCategoryAndInstructor(String categoryName,String levelName,String instuctor);
	public int getCountOfmoduleQuizzes(int courseId);
	
	public double getProgressByCourseId(int courseId);
	public byte[] countOfQuizIdByReports(int courseId,String courseName);
}
