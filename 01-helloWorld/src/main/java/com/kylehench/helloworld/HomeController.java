package com.kylehench.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/hello-name")
	public String helloName() {
		return "Hello Mr. Kyle";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotation are cool too!";
	}
}