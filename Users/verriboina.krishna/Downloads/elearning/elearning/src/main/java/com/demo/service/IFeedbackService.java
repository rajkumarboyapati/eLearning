package com.demo.service;

import java.util.List;

import com.demo.entities.Feedback;

public interface IFeedbackService {
public List<Feedback> getAllFeedBacks();
public Feedback addFeedback(Feedback feedback);
public Feedback deleteFeedbackById(int feedbackId);
public Feedback getFeedback(int feeddbackId);
}
