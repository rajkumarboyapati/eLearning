package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;
import com.demo.entities.Vedio;
@Repository
public interface VedioRepository extends JpaRepository<Vedio, Integer>{

}
