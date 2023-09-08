package com.app.kshithi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/home","/"})
	public String showHome() {
		System.out.println("Home Screen");
		return "home";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		System.out.println("Hello Screen");
		return "hello";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		System.out.println("Login Screen");
		return "login";
	}
}
