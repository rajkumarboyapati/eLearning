package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Level;
import com.demo.entities.User;


@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{

}
