package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Assignment;
import com.demo.entities.User;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{

}
