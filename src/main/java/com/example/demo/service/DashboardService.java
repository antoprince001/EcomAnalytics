package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CompanyRevenue;
import com.example.demo.entity.EmployeeInformation;
import com.example.demo.entity.OrderCollectionStatus;
import com.example.demo.entity.OrderReceived;
import com.example.demo.entity.ProductCategory;


public interface DashboardService {

	HashMap<String,Object> getTodayRevenueDash();

	List<OrderCollectionStatus> getOrderCollection();

	List<EmployeeInformation> getAllEmployee();
	
	EmployeeInformation getEmployee(int pk);

	List<OrderReceived> getAllOrderReceived();

	List<ProductCategory> getBestCategory();
	
	EmployeeInformation addEmployee(EmployeeInformation employeeInformation);
	
	EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);
	
	void deleteEmployee(EmployeeInformation employeeInformation);
}
