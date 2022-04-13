package com.kylehench.javadojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kylehench.javadojooverflow.models.Answer;
import com.kylehench.javadojooverflow.services.AnswerService;
import com.kylehench.javadojooverflow.services.QuestionService;

@Controller
public class AnswerController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;

	@PostMapping("/answers/create")
	public String answers_create(@Valid @ModelAttribute("newAnswer") Answer newAnswer,
			BindingResult result,
			@RequestParam(value="question_id") long question_id,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", questionService.read(question_id));
			return "questions_id.jsp";
		}
		newAnswer.setQuestion(questionService.read(question_id));
		answerService.create(newAnswer);
		return "redirect:/questions/" + question_id;
	}
}
