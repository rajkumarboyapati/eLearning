package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Certificates;
@Repository
public interface CertificatesRepository extends JpaRepository<Certificates, Long>{

}
