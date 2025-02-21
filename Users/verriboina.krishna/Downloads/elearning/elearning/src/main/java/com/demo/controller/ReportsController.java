package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Reports;
import com.demo.service.IReportsService;

@RestController
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	private IReportsService reportsService;
	
	@GetMapping("allreports")
	public ResponseEntity<?> getAllReports(){
		List<Reports> reportsList=reportsService.getReports();
		if(!reportsList.isEmpty()) {
			return new ResponseEntity<List<Reports>>(reportsList,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No reports Found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addreport")
	public ResponseEntity<?> addReports(@RequestBody Reports reports){
		Reports reportSaved=reportsService.addReports(reports);
		if(reportSaved!=null) {
			return new ResponseEntity<Reports>(reportSaved,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Unable to Save the Report",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("reportsbymanagerId/{managerId}")
	public ResponseEntity<?> getReportsBymanagerId(@PathVariable("managerId")int managerId){
		List<Reports> r=reportsService.getreportsByManager(managerId);
		if(!r.isEmpty()) {
			return new ResponseEntity<List<Reports>>(r,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("reports are not generated",HttpStatus.NOT_FOUND);
					
		}
	}
	
}
