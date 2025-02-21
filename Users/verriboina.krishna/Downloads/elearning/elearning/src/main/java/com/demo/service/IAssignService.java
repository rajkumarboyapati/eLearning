package com.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Assign;

public interface IAssignService {
	public Assign assin(Assign assign);
	public List<Assign> getAll();
	public int getTeamId(int emloyeeId);
	public Assign addAssign(int employeeId,int managerId,int courseId);
	public Assign getAssignedEmployeeCourse(int courseId, int employeeId);
}
