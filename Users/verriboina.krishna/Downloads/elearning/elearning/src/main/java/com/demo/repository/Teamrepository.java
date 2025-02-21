package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Team;
import com.demo.entities.User;
@Repository
public interface Teamrepository extends JpaRepository<Team, Integer>{
	@Query(value="select t.team_id from team t inner join team_employee_list te on t.team_id=te.team_team_id inner join employee e on te.employee_list_employee_id=e.employee_id where employee_id=:employeeId",nativeQuery = true)
	public int  getTeamId(@Param("employeeId") int employeeId);
}
