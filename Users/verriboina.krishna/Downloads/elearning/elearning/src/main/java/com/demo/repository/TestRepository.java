package com.demo.repository;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.TestVideo;

@Repository
public interface TestRepository extends JpaRepository<TestVideo, Long>{
	

}
