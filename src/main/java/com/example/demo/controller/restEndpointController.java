package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeInformation;
import com.example.demo.service.DashboardService;

@RestController
public class restEndpointController {

	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/employees")
	public List<EmployeeInformation> getAllEmp(){
			return dashboardService.getAllEmployee();
	}
	
	@RequestMapping(method= RequestMethod.POST , value="/employee/add")
	public String saveEmployee(@RequestBody EmployeeInformation employeeInfo) {
		if(dashboardService.addEmployee(employeeInfo) != null) {
			return "Employee Data Added Successfully";
		}
		else {
			return "Error Saving Employee Info";
		}
	}
	
	@RequestMapping(method= RequestMethod.PUT , value="/employee/delete")
	public String deleteEmployee(@RequestParam(name="empId",required=true) int pk) {
		try {
			
			dashboardService.deleteEmployee(dashboardService.getEmployee(pk));
			return "deleted";
		}
		catch(Exception e){
			System.out.println(e.toString());
			return "error";
		}
	}
	
}
