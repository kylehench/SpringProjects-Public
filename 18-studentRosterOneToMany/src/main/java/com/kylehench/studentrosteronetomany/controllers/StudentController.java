package com.kylehench.studentrosteronetomany.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.studentrosteronetomany.models.Student;
import com.kylehench.studentrosteronetomany.services.DormService;
import com.kylehench.studentrosteronetomany.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	@Autowired
	private DormService dormService; 
    
    @GetMapping("/new")
    public String nouveau(@ModelAttribute("newStudent") Student newStudent, Model model) {
    	model.addAttribute("dorms", dormService.readAll());
    	return "students_new.jsp";
    }    
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult result,
    		@RequestParam(value="dorm_id", required=false) Long dorm_id, Model model) {
    	if (dorm_id==null) model.addAttribute("dormError", "please select a dorm");
    	if (result.hasErrors() || dorm_id==null) {
    		model.addAttribute("dorms", dormService.readAll());
    		return "students_new.jsp";
    	}
    	newStudent.setDorm(dormService.read(dorm_id));
    	studentService.create(newStudent);
    	return "redirect:/dorms";
    }    
}