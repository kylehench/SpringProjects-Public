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
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.studentrosteronetomany.models.Dorm;
import com.kylehench.studentrosteronetomany.models.Student;
import com.kylehench.studentrosteronetomany.services.DormService;
import com.kylehench.studentrosteronetomany.services.StudentService;

@Controller
@RequestMapping("/dorms")
public class DormController {
	
	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;
    
    @GetMapping
    public String home(Model model) {
    	model.addAttribute("dorms", dormService.readAll());
        return "dorms.jsp";
    }    
    
    @GetMapping("/new")
    public String nouveau(@ModelAttribute("newDorm") Dorm newDorm) {
    	return "dorms_new.jsp";
    }    
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("newDorm") Dorm newDorm, BindingResult result) {
    	if (result.hasErrors()) return "dorms_new.jsp";
    	dormService.create(newDorm);
    	return "redirect:/dorms";
    }    
    
    // view dorm
    @GetMapping("/{id}")
    public String view(@PathVariable("id") long id, Model model) {
    	model.addAttribute("dorm", dormService.read(id));
    	model.addAttribute("all_students", studentService.readAll());
    	return "dorms_id.jsp";
    }    
    
    // assign existing student to dorm
    @PostMapping("/assign")
    public String assign(Model model,
    		@RequestParam(value="dorm_id", required=false) Long dorm_id,
    		@RequestParam(value="student_id", required=false) Long student_id) {
    	Student student = studentService.read(student_id);
    	student.setDorm(dormService.read(dorm_id));
    	studentService.update(student);
    	return "redirect:/dorms/" + dorm_id;
    }
    
    // clear dorm assignemnt for a student
    @GetMapping("/clearAssignment/{dorm_id}/{student_id}")
    public String unassign(@PathVariable("student_id") long student_id,
    		@PathVariable("dorm_id") long dorm_id) {
    	Student student = studentService.read(student_id);
    	student.setDorm(null);
    	studentService.update(student);
    	return "redirect:/dorms/{dorm_id}";
    }
}