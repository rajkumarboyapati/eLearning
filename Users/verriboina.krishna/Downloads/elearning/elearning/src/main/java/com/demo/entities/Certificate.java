package com.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

public class Certificate {
private int certificate;
@ManyToOne(cascade =CascadeType.ALL )
private Employee employeeRef;
@ManyToOne(cascade = CascadeType.ALL)
private Course courseRef;
private LocalDate issuedDate;


}
