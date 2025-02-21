package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Assign;
import com.demo.entities.Course;
import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.entities.Team;
import com.demo.repository.AssignRepository;
import com.demo.repository.CourseRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.ManagerRepository;
import com.demo.repository.Teamrepository;

@Service
public class AssignService implements IAssignService{
	@Autowired
	private AssignRepository assignrepository;
	@Autowired
	Teamrepository teamrepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Assign assin(Assign assign) {
		Assign assin=assignrepository.save(assign);

		return assin;
	}

	@Override
	public List<Assign> getAll() {
		 List<Assign> assignList=assignrepository.findAll();
		return assignList;
	}

	@Override
	public int getTeamId(int emloyeeId) {
		int teamid=teamrepository.getTeamId(emloyeeId);
		
		return teamid;
	}

	@Override
	public Assign addAssign(int employeeId, int managerId, int courseId) {
		Assign assign=new Assign();
		Employee employee=employeeRepository.findById(employeeId).get();
		Course course=courseRepository.findById(courseId).get();
		Manager manager=managerRepository.findById(managerId).get();
		int teamid=teamrepository.getTeamId(employeeId);
		Team team=teamrepository.findById(teamid).get();
		
		assign.setCourseRef(course);
		assign.setEmployeeRef(employee);
		assign.setManagerRef(manager);
		assign.setTeamRef(team);
		assignrepository.save(assign);
		
		return assign;
	}

	@Override
	public Assign getAssignedEmployeeCourse(int courseId, int employeeId) {
		Assign a=assignrepository.getAssignedEmployeeCourse(courseId, employeeId);
		return a;
	}
	
}
