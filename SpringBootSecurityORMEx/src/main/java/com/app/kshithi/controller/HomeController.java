package com.app.kshithi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//EVERY ONCE CAN ACCESS
	// .antMatchers("/home").permitAll
	@GetMapping({"/home","/"})
	public String showHome() {
		System.out.println("Home");
		return "home";
	}
	
	//ONLY AFTER LOGIN
	// .antMatchers("/hello").authenticated()
	@GetMapping("/hello")
	public String showHello() {
		System.out.println("Hello");
		return "hello";
	}
	
	//ONLY ADMIN After login
	// .antMatchers("/admin").hasAuthority("ADMIN")
	@GetMapping("/admin")
	public String showAdmin() {
		System.out.println("Admin");
		return "admin";
	}
	
	//ONLY CUSTOMER After login
	// .antMatchers("/customer").hasAuthority("CUSTOMER")
	@GetMapping("/customer")
	public String showCustomer() {
		System.out.println("Customer");
		return "customer";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		System.out.println("Login");
		return "login";
	}
}