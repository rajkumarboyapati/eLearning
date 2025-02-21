package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;
@Repository
public interface AdminRepository extends JpaRepository<User, Integer>{

}
