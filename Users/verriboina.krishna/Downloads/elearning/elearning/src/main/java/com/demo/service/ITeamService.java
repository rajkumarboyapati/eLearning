package com.demo.service;

import java.util.List;

import com.demo.entities.Team;

public interface ITeamService {
public List<Team> getAllTeams();
public Team getTeamByTeamId(int teamId);
public Team addTeam(Team team);
public Team DeleteTeamById(int id);
public Team updateTeam(Team team);

}
