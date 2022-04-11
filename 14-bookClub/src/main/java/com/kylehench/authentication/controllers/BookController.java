package com.kylehench.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kylehench.authentication.models.Book;
import com.kylehench.authentication.services.BookService;
import com.kylehench.authentication.services.UserService;

@Controller
public class BookController {

	@Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public String books(Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
		model.addAttribute("userName", session.getAttribute("userName"));
		model.addAttribute("books", bookService.readAll());
    	return "books.jsp";
    }
    
    @GetMapping("/books/new")
    public String booksNew(@ModelAttribute("newBook") Book newBook, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	return "books_new.jsp";
    }
    
    @PostMapping("/books/create")
    public String booksCreate(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	if (result.hasErrors()) {
    		return "books_new.jsp";
    	}
    	newBook.setUser(userService.read((long) session.getAttribute("userId")));
    	bookService.save(newBook);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}/edit")
    public String booksEdit(@PathVariable long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	Book book = bookService.read(id);
    	// log user out if inappropriate access
    	if (book.getUser().getId() != (long) session.getAttribute("userId")) return "redirect:/logout";
    	model.addAttribute("book", book);
    	return "books_edit.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String booksUpdate(@PathVariable long id, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	if (result.hasErrors()) {
    		return "books_edit.jsp";
    	}
    	Book oldBook = bookService.read(id);
    	// add user to book and log out if inappropriate access
    	book.setUser(oldBook.getUser());
    	if (book.getUser().getId() != (long) session.getAttribute("userId")) return "redirect:/logout";
    	bookService.save(book);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}")
    public String booksId(@PathVariable long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	model.addAttribute("book", bookService.read(id));
    	return "books_id.jsp";
    }
}
