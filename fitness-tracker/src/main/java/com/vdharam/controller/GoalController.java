package com.vdharam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vdharam.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model) {
		model.addAttribute("goal",new Goal(10));
		
		return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors : " + result.hasErrors());
		System.out.println(goal.getMinutes());
		
		return "redirect:addMinutes.html";
	}
}
