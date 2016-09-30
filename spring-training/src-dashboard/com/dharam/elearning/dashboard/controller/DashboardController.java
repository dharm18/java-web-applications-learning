package com.dharam.elearning.dashboard.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dashboard")
public class DashboardController {

	@RequestMapping("/index.htm")
	public String index(){
		return "redirect:/dashboard/home.htm";
	}
	
	@RequestMapping("home.htm")
	public ModelAndView home(){
		return new ModelAndView("dashboard/home","date",new Date());
	}
}
