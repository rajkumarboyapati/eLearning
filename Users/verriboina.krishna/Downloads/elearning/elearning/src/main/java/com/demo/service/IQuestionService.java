package com.demo.service;

import java.util.List;

import com.demo.entities.Questions;
import com.demo.entities.Reports;

public interface IQuestionService {
	public List<Questions> getAllQuestions(int QuizId);
	public Reports addoptions(List<String> ls,int quizId,int employeeId,int courseId);

}
