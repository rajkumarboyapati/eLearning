package com.demo.service;

import java.util.List;

import com.demo.entities.Reports;

public interface IReportsService {
	
	public List<Reports> getReports();
	public Reports addReports(Reports report);
public List<Reports> getreportsByManager(int managerId);
}
