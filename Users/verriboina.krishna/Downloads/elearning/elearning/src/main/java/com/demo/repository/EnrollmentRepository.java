package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{

}
