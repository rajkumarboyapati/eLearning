package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Modules;
import com.demo.entities.User;
@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer>{

}
