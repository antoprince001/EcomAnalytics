package com.example.demo.service.Impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CompanyRevenue;
import com.example.demo.entity.EmployeeInformation;
import com.example.demo.entity.OrderCollectionStatus;
import com.example.demo.entity.OrderReceived;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repositories.CompanyRevenueRepository;
import com.example.demo.repositories.EmployeeInformationRepository;
import com.example.demo.repositories.OrderCollectionStatusRepository;
import com.example.demo.repositories.OrderReceivedRepository;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	private CompanyRevenueRepository companyRevenueRepository;
	
	@Autowired
	private EmployeeInformationRepository employeeInformationRepository;
	
	@Autowired
	private OrderCollectionStatusRepository orderCollectionStatusRepository;
	
	@Autowired
	private OrderReceivedRepository orderReceivedRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public HashMap<String,Object> getTodayRevenueDash(){
		
		HashMap<String,Object> populateCompanyRev = new HashMap<>();
		
		List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();
		
		List<String> label = new ArrayList<>();
		List<String> _revenue = new ArrayList<>();
		
		double totalMargin = 0;
		double totalExpense = 0;
		double totalRevenue = 0;
		Locale locale = new Locale("en" ,"US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		
		for(CompanyRevenue companyRevenue : companyRevenueList) {
			label.add(companyRevenue.getMonth());
			_revenue.add(String.valueOf(companyRevenue.getRevenue()));
			totalExpense += companyRevenue.getExpense();
			totalMargin += companyRevenue.getMargins();
			totalRevenue += companyRevenue.getRevenue();
		}
		
		populateCompanyRev.put("crLabels", label.toString());
		populateCompanyRev.put("crRevenue", _revenue.toString());
		populateCompanyRev.put("totalExpense", currencyFormatter.format(totalExpense));
		populateCompanyRev.put("totalMargin", currencyFormatter.format(totalMargin));
		populateCompanyRev.put("totalRevenue", currencyFormatter.format(totalRevenue));
		
		return populateCompanyRev;
		
	}
	
	
	@Override
	public List<ProductCategory> getBestCategory(){
		
		return productCategoryRepository.findByBestCategory(true);
	}
	
	@Override
	public List<OrderReceived> getAllOrderReceived(){
		
		return orderReceivedRepository.findAll();
	}
	
	@Override
	public List<OrderCollectionStatus> getOrderCollection(){
		
		return orderCollectionStatusRepository.findAll();
	}
	
	@Override
	public List<EmployeeInformation> getAllEmployee(){
		
		return employeeInformationRepository.findAll();
	}
	
	@Override
	public EmployeeInformation getEmployee(int pk) {
		
		return employeeInformationRepository.findByPk(pk);
	}
	
	@Override
	public EmployeeInformation addEmployee(EmployeeInformation employeeInformation){
		
		return employeeInformationRepository.save(employeeInformation);
	}
	
	@Override
	public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation){
		
		return employeeInformationRepository.save(employeeInformation);
	}
	
	@Override
	public void deleteEmployee(EmployeeInformation employeeInformation){
		
			employeeInformationRepository.delete(employeeInformation);
	}
	
	
	
}
