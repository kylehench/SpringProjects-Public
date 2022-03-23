package com.kylehench.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Controller
public class MainController {

	@RequestMapping
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE', the 'd' of 'MMMM', 'yyyy");
		String dateString = now.format(dateFormat);
		model.addAttribute("date", dateString);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh':'mm a");
		String dateString = now.format(timeFormat);
		model.addAttribute("time", dateString);
		return "time.jsp";
	}
}