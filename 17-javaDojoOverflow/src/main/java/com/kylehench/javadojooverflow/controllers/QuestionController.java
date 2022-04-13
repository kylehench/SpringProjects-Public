package com.kylehench.javadojooverflow.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.javadojooverflow.models.Answer;
import com.kylehench.javadojooverflow.models.Question;
import com.kylehench.javadojooverflow.models.Tag;
import com.kylehench.javadojooverflow.services.QuestionService;
import com.kylehench.javadojooverflow.services.TagService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	TagService tagService;

	@GetMapping("/questions")
	public String questions(Model model) {
		List<Question> questions = questionService.readAll();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	// new question
	@GetMapping("/questions/new")
	public String questions_new(@ModelAttribute("newQuestion") Question newQuestion, Model model) {
		return "questions_new.jsp";
	}
	@PostMapping("/questions/create")
	public String questions_create(@Valid @ModelAttribute("newQuestion") Question newQuestion,
			BindingResult result,
			Model model,
			@RequestParam(value="tagsString") String tagsString) {
		List<Tag> tags = tagService.tagsSubmission(tagsString);
		if (tags==null || result.hasErrors()) {
			if (tags==null) model.addAttribute("errorTag", "enter up to 3 tags");
			return "questions_new.jsp";
		}
		newQuestion.setTags(tags);
		for (Tag tag:tags) {
			if (tagService.readByName(tag.getName())==null) tagService.create(tag);
		}
		questionService.create(newQuestion);
		return "redirect:/questions";
	}
	
	// view/edit question
	@GetMapping("/questions/{id}")
	public String questions_id(@PathVariable("id") long id, Model model,
			@ModelAttribute("newAnswer") Answer newAnswer) {
		model.addAttribute("question", questionService.read(id));
		return "questions_id.jsp";
	}
}