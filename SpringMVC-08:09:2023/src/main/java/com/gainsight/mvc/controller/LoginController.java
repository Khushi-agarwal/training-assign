package com.gainsight.mvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.UserDAO;
import com.gainsight.mvc.entity.User;

@Controller
public class LoginController {
	@Autowired
	UserDAO udao;
	

	@GetMapping("/loginPage")
	public String getLoginPage()
	{
		return "Login";
	}
	
	@PostMapping("/validateUser")
	//@GetMapping("/validateUser")
	public String authenticateUser(@RequestParam("uname")String username,@RequestParam("pword")String password,Model model,HttpServletResponse response)

	{
		String message="Invalid Username/Password....TryAgain!";
		User user=new User(username,password);
		if(udao.validateUser(user))
		{ 
			Cookie c=new Cookie("username",username);
			response.addCookie(c);
		//if(username.equals("Ajay") && password.equals("Ajay@123"))
		//	message="Welcome to the world of JAVA";
			return "Search";
		}
		model.addAttribute("message",message);
		
		return "Display";
		
	}
	
	
}

