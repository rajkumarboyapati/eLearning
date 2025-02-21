package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Course;
import com.demo.service.CourseService;
@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@PostMapping("addcourse")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		  Course course1=courseService.addCourse(course);
		 return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@GetMapping("/getallcourses")
	public ResponseEntity<?> getAllCourses(){
		List<Course> courseList=courseService.getAllCourses();
		if(courseList!=null) {
			return new ResponseEntity<>(courseList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No courses are present",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getcoursebyid/{courseid}")
	public ResponseEntity<?> getCourseById(@PathVariable("courseid") int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Course doesnot found with given courseId",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updatecourse")
	public ResponseEntity<?> updateCourse(@RequestBody Course course){
		Course course1=courseService.updateCourse(course);
		return new ResponseEntity<>(course1,HttpStatus.OK);
	}
	@DeleteMapping("/deletecourse/{courseid}")
	public ResponseEntity<?> deleteCourseById(@PathVariable("courseid") int courseid){
		Course course=courseService.deleteCourse(courseid);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("course doesnot found with given courseid ",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/get/{categoryname}/{levelname}")
	public ResponseEntity<?> getCourseByCategoryAndLevel(@PathVariable("categoryname")String CategoryName,@PathVariable("levelname")String levelname ) {
		Course course=courseService.getCourseByLevelAndCategory(CategoryName, levelname);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity<>("course not found with given level and category",HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/get/{categoryname}/{levelname}/{instructorname}")
	public ResponseEntity<?> getCourseByCategoryAndLevelAndInstructor(@PathVariable("categoryname")String CategoryName,@PathVariable("levelname")String levelname ,@PathVariable("instructorname")String instructorName) {
		Course course=courseService.getCourseByLevelAndCategoryAndInstructor(CategoryName, levelname,instructorName);
		if(course!=null) {
			return new ResponseEntity<>(course,HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity<>("course not found with given level and category and instructor ",HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/get/{courseid}")
	public int getCountOfmoduleQuizzes(@PathVariable("courseid")int courseId) {
		 int getcountofmoduleQuizzes=courseService.getCountOfmoduleQuizzes(courseId);
		 return getcountofmoduleQuizzes;
	}
	@GetMapping("/getprogress/{courseid}")
	public double getProgressByCourseId(@PathVariable("courseid")int courseId) {
		double progressbycourseid=courseService.getProgressByCourseId(courseId);
		return progressbycourseid;
	}
//	@GetMapping("/getcount/{courseid}/{username}")
//	public ResponseEntity<?> countOfQuizIdByReports(@PathVariable("courseid")int  courseId,@PathVariable("username") String userName) {
//		byte[] countOfQuizIdByReports=courseService.countOfQuizIdByReports(courseId, userName);	
//		 HttpHeaders headers = new HttpHeaders();
//	        headers.add("Content-Disposition", "attachment; filename=certificate.pdf");
//	        return new ResponseEntity<>(countOfQuizIdByReports, headers, HttpStatus.OK);
//	}
	@GetMapping("/getcount/{courseid}/{username}")
	public ResponseEntity<?> countOfQuizIdByReports(@PathVariable("courseid") int courseId, @PathVariable("username") String userName) {
	    byte[] pdfBytes = courseService.countOfQuizIdByReports(courseId, userName);
	    
	    if (pdfBytes == null || pdfBytes.length == 0) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating PDF.");
	    }
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=certificate.pdf");
	   
	    headers.add("Content-Type", "application/pdf");  
	    return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}

	

}
