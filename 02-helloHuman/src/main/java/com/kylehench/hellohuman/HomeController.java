package com.kylehench.hellohuman;

import java.util.Objects;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

	@RequestMapping
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String last_name) {
		if (name==null) {
			return "Hello human";
		} else {
			// Objects.toString(last_name, "") returns empty string if last_name is null
			return String.format("Hello %s %s", name, Objects.toString(last_name, ""));
		}
	}
}
