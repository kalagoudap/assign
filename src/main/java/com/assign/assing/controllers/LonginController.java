package com.assign.assing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assign.assing.Entity.UserRegistration;
import com.assign.assing.Services.UserService;
import com.assign.assing.dto.Userdto;

@Controller
public class LonginController
{
	@Autowired
	UserService userservice;

	long id;

	@PostMapping("/login")
	public String loginform(@ModelAttribute Userdto userdto, Model model)
	{
		UserRegistration data=userservice.loginform(userdto);	
		if(data!=null)
		{
			id=data.getId();
			model.addAttribute("userlist", data);
			return "userlist";
		}
		else
		{
			return "unsuccessfull";
		}
	}
}
