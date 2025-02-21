package com.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entities.Course;
import com.demo.entities.Material;
import com.demo.entities.Modules;
import com.demo.repository.CourseRepository;
import com.demo.repository.ModulesRepository;
import com.demo.repository.ReportsRepository;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@Service
public class CourseService implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ModulesRepository modulesRepository;
	@Autowired
	ReportsRepository reportsRepository;
	@Autowired
    private CertificatesService certificatesService; 
	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course deleteCourse(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
			courseRepository.deleteById(courseId);
		}
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		Course c=new Course();
		
		
		courseRepository.save(course);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList=new ArrayList<>();
		courseList=courseRepository.findAll();
		return courseList;
	}

	@Override
	public Course getCourseById(int courseId) {
		Course course=null;
		if(courseRepository.existsById(courseId)) {
			course=courseRepository.findById(courseId).get();
		}
		return course;
	}

	@Override
	public Course getCourseByLevelAndCategory(String categoryName, String levelName) {
		Course course=null;
		  course=courseRepository.getCourseByLevelAndCategory(categoryName, levelName);
		return course;
	}

	@Override
	public Course getCourseByLevelAndCategoryAndInstructor(String categoryName, String levelName, String instuctor) {
		Course course=null;
		course=courseRepository.getCourseByLevelAndCategoryAndInstructor(categoryName, levelName, instuctor);
		
		return course;
	}
	int countOfQuizzesByCourseId=0;
	@Override
	public int getCountOfmoduleQuizzes(int courseId) {
		 countOfQuizzesByCourseId=courseRepository.getCountOfmoduleQuizzes(courseId);
		
		return countOfQuizzesByCourseId;
	}
	double progress=0;
	@Override
	public double getProgressByCourseId(int courseId) {
		progress=reportsRepository.getProgressByCourseId(courseId);
		return progress;
	}
	@Override
	public byte[] countOfQuizIdByReports(int courseId, String userName) {
		

	    int countOfQuizIdByReports = reportsRepository.countOfQuizIdByReports(courseId);
	    countOfQuizzesByCourseId=courseRepository.getCountOfmoduleQuizzes(courseId);

	    Course course = courseRepository.findById(courseId).orElse(null);
	    String courseName = course != null ? course.getCourseName() : "Unknown Course";
	      byte[] certificate = null;
	    
	    if (countOfQuizIdByReports == countOfQuizzesByCourseId) {
	        if (progress > 70.0) {
	           
	        	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    	    Document document = new Document();
	    	    try {
	    	        PdfWriter.getInstance(document, outputStream);
	    	        document.open();
	    	        document.add(new Paragraph("Certificate for " + userName));
	    	        document.add(new Paragraph("Course ID: " + courseId));
	    	        document.close();
	    	    } catch (DocumentException e) {
	    	        e.printStackTrace();
	    	    }
	    	    return outputStream.toByteArray();
	        
	        }
	        else {
	        	return certificate;
	        }
	    }

	    return certificate;
	}

	 


	
	
	  


	
	

}


