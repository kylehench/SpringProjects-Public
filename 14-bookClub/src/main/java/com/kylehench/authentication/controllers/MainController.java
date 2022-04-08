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

import com.kylehench.authentication.models.Book;
import com.kylehench.authentication.models.LoginUser;
import com.kylehench.authentication.models.User;
import com.kylehench.authentication.services.BookService;
import com.kylehench.authentication.services.UserService;

@Controller
public class MainController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        User user = userService.register(newUser, result);
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	session.removeAttribute("userName");
    	return "redirect:/";
    }
    
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
    		model.addAttribute("newBook", new Book());
    		return "books_new.jsp";
    	}
    	newBook.setUser(userService.read((long) session.getAttribute("userId")));
    	bookService.save(newBook);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}")
    public String booksId(@PathVariable long id, Model model, HttpSession session) {
    	if (session.getAttribute("userId")==null) return "redirect:/logout";
    	model.addAttribute("book", bookService.read(id));
    	return "books_id.jsp";
    }
}