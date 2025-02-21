package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Questions;
import com.demo.entities.Reports;
import com.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionsController {
	@Autowired
	QuestionService questionService;
	@GetMapping("/getQuestion/{quizId}")
	public ResponseEntity<?> getAllQuestions(@PathVariable("quizId") int quizId){
		List<Questions> qlist=questionService.getAllQuestions(quizId);
		return new ResponseEntity<>(qlist,HttpStatus.OK);
	}
	@PostMapping("/addreports/{stringlist}/{quizid}/{employeeid}/{courseid}")
	public ResponseEntity<?> addReports(@PathVariable("stringlist") List<String> slist,@PathVariable("quizid")int quizid,@PathVariable("employeeid")int empid,@PathVariable("courseid")int courseid){
		Reports reports=questionService.addoptions(slist, quizid, empid, courseid);
		return new ResponseEntity<>(reports,HttpStatus.OK);
	}

}
