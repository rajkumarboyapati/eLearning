package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Team;
import com.demo.repository.Teamrepository;
@Service
public class TeamService implements ITeamService {
@Autowired
private Teamrepository teamrepository;
	@Override
	public List<Team> getAllTeams() {
		List<Team> teamList=teamrepository.findAll();
		return teamList;
	}

	@Override
	public Team getTeamByTeamId(int teamId) {
		Team team=teamrepository.findById(teamId).get();
		return team;
	}

	@Override
	public Team addTeam(Team team) {
		Team t=teamrepository.save(team);
		return t;
	}

	@Override
	public Team DeleteTeamById(int id) {
		Team team=null;
		if(teamrepository.existsById(id)) {
			team=teamrepository.findById(id).get();
			teamrepository.delete(team);
		}
		return team;
	}

	@Override
	public Team updateTeam(Team team) {
		Team t=teamrepository.save(team);
		return t;
	}

	

}
