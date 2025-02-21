package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Feedback;
import com.demo.entities.User;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
