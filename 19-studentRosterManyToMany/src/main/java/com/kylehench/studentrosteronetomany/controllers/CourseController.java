package com.kylehench.studentrosteronetomany.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kylehench.studentrosteronetomany.models.Course;
import com.kylehench.studentrosteronetomany.services.CourseService;

@Controller
@RequestMapping("/classes")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	// view classes
	@GetMapping
	public String viewAll(Model model) {
		model.addAttribute("courses", courseService.readAll());
		return "courses.jsp";
	}

	// view a class
	@GetMapping("/{id}")
	public String viewAll(@PathVariable("id") long id, Model model) {
		model.addAttribute("course", courseService.read(id));
		return "courses_id.jsp";
	}

	// new class
	@GetMapping("/new")
	public String nouveau(@ModelAttribute("newCourse") Course newCourse) {
		return "courses_new.jsp";
	}
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("newCourse") Course newCourse,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) return "courses_new.jsp";
		courseService.create(newCourse);
		model.addAttribute("courses", courseService.readAll());
		return "courses.jsp";
	}
	
}