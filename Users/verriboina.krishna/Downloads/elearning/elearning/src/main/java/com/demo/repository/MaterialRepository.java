package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer>{

}
