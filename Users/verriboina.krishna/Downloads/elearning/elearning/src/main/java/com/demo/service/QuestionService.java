package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Course;
import com.demo.entities.Employee;
import com.demo.entities.Questions;
import com.demo.entities.Reports;
import com.demo.repository.CourseRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.QuestionsRepository;
import com.demo.repository.ReportsRepository;

@Service
public class QuestionService implements IQuestionService{
	@Autowired
	QuestionsRepository questionsRepository;
	@Autowired
	ReportsRepository reportsRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	List<Questions> ql=new ArrayList<>();

	@Override
	public List<Questions> getAllQuestions(int QuizId) {
		 ql=questionsRepository.getAllQuestions(QuizId);
		return ql;
	}

	@Override
	public Reports addoptions(List<String> ls,int quizId,int employeeId,int courseId) {
		double sum=0;
		ql=questionsRepository.getAllQuestions(quizId);
		for(int i=0;i<ql.size();i++){
			for(int j=0;j<ls.size();j++ ) {
				if(i==j) {
				if(ql.get(i).getCorrectAnswer().equals(ls.get(j))) {
					sum=sum+ql.get(i).getWeightage();
				}
				}
			}
		
		}
		double total=0;
		for(Questions q:ql) {
			total=total+q.getWeightage();
		}
		 Course course=courseRepository.findById(courseId).get();
		 Employee  employee=employeeRepository.findById(employeeId).get();
		double percentage=(sum/total)*100;
		Reports reports=new Reports();
		reports.setProgress(percentage);
		reports.setQuizId(quizId);
		reports.setCourseRef(course);
		reports.setEmployee(employee);
		reports.setQuizScore((int)sum);
		reportsRepository.save(reports);
		
		return reports;
	}
	

}
