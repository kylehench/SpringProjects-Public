package com.kylehench.studentrosteronetomany.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.kylehench.studentrosteronetomany.models.Course;
import com.kylehench.studentrosteronetomany.models.Student;
import com.kylehench.studentrosteronetomany.services.CourseService;
import com.kylehench.studentrosteronetomany.services.DormService;
import com.kylehench.studentrosteronetomany.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	@Autowired
	private DormService dormService; 
	@Autowired
	private CourseService courseService; 
	
	// view students
	@GetMapping
	public String viewAll(Model model) {
		model.addAttribute("students", studentService.readAll());
		return "students.jsp";
	}
	
	// view a student
	@GetMapping("/{id}")
	public String view(@PathVariable("id") long id, Model model) {
		model.addAttribute("courses", courseService.readNotInStudent(studentService.read(id)));
		model.addAttribute("student", studentService.read(id));
		return "students_id.jsp";
	}
    
	// new student
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
    
    // add course to student
    @PostMapping("/assignClass")
    public String assignClass(@RequestParam(value="student_id", required=false) Long student_id,
    		@RequestParam(value="course_id", required=false) Long course_id) {
    	Student student = studentService.read(student_id);
    	List<Course> courses = student.getCourses();
    	for (Course course:courses) {
    		if (course.getId()==course_id) return "redirect:/students/" + student_id;
    	}
    	courses.add(courseService.read(course_id));
    	student.setCourses(courses);
    	studentService.update(student);
    	return "redirect:/students/" + student_id;
    }
    // drop a course for a student
 // clear dorm assignemnt for a student
    @GetMapping("/clearClass/{student_id}/{course_id}")
    public String unassign(@PathVariable("student_id") long student_id,
    		@PathVariable("course_id") long course_id) {
    	Student student = studentService.read(student_id);
    	List<Course> courses = student.getCourses();
    	courses.remove(courseService.read(course_id));
    	studentService.update(student);
    	return "redirect:/students/{student_id}";
    }
}