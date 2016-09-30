package com.dharam.elearning.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dharam.elearning.user.bean.User;
import com.dharam.elearning.user.service.IUserService;
import com.dharam.elearning.user.util.UserValidator;

@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping("workbench*")
	public ModelAndView workbench(){
		List<User> users = userService.list();
		return new ModelAndView("user/workbench", "users", users);
	}
	
	@ModelAttribute("codes")
	public List<String> populateSportTypes() {
		List<String> codes = new ArrayList<String>();
		codes.add("A");
		codes.add("B");
		codes.add("C");
		return codes;
	}
	
	@RequestMapping("add")
	public ModelAndView addUser(){
		return new ModelAndView("user/add","user", new User());
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public String create(@ModelAttribute @Validated User user,BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "user/add";
		} else {
			userService.add(user);
			status.setComplete();
			return "redirect:add";
		}
	}
	
	@RequestMapping("edit/{id}")
	public ModelAndView editUser(@PathVariable Long id){
		User user = userService.retrieveById(id);
		return new ModelAndView("user/edit","user", user);
	}
	
	@RequestMapping("update")
	public String updateUser(@ModelAttribute @Validated User user,BindingResult result, SessionStatus status){
		if (result.hasErrors()) {
			return "user/add";
		} else {
			user = userService.update(user);
			status.setComplete();
			return "redirect:workbench";
		}
	}
	
	@RequestMapping("delete")
	public String deleteUser(@RequestParam("id") Long id){
		
		User user = userService.retrieveById(id);
		if(user != null) {
			userService.delete(user);
		}
		return "redirect:workbench";
	}
	
}
