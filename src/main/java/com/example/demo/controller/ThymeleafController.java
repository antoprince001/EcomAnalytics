package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.DashboardService;

@Controller
public class ThymeleafController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/dashboard")
	public String getDashDetail(Model model) {
		
		model.addAttribute("cr",dashboardService.getTodayRevenueDash());
		model.addAttribute("ei",dashboardService.getAllEmployee());
		model.addAttribute("pc",dashboardService.getBestCategory());
		return "/dashboard";
	}
}
