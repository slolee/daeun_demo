package com.example.daeun_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello, Spring Boot!";
	}

	@GetMapping("/hello2")
	public String hello2() {
		return "Hello, Spring Boot!!";
	}
}
