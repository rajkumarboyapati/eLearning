package com.demo.testservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.entities.Employee;
import com.demo.entities.Manager;
import com.demo.entities.Team;
import com.demo.entities.User;
import com.demo.repository.Teamrepository;
import com.demo.repository.UserRepository;
import com.demo.service.TeamService;

@ExtendWith(SpringExtension.class)
public class TestUserService {
	@Mock
	private Teamrepository teamRepository;
	@InjectMocks
	private TeamService teamService;
	public List<Team> getTeams(){
		Team t=new Team();
		List<Team> t1=new ArrayList<>();
		t.setTeamName("gopi");
		t.setTeamId(1);
		Manager m=new Manager();
		m.setManagerId(1);
		m.setManagername("rahul");
		
		User u=new User();
		u.setUserId(1);
		u.setEmail("vgopikrishna77@gmail.com");
		u.setPassword("123");
		u.setRole("admin");
		m.setUserRef(null);
		t.setManagerRef(m);
		Employee e=new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("gopi");
		e.setEmployeeContact("12345");
		e.setUserRef(u);
		List<Employee> el=new ArrayList<>();
		el.add(e);
		t.setEmployeeList(el);
		t1.add(t);
		
		return t1;
	}
	@Test
	public void getTeamService() {
		
		when(teamRepository.findAll()).thenReturn(getTeams());
		teamService.getAllTeams();
	}
	@Test
	public void getTeam() {
		
		Optional<Team> t=Optional.of(getTeams().get(0));
		when(teamRepository.findById(any())).thenReturn(t);
		teamService.getTeamByTeamId(1);
		
	}

}
