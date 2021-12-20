package com.codingdojo.bookclub.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;



@Controller
public class BookController {

    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private BookService bookServ;

    
    @GetMapping("/books/{id}")
    public String booksId(@PathVariable("id") Long id,
    						Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	Book book = this.bookServ.findOneBook(id);
    	model.addAttribute("book", book);
    	return "show.jsp";
    }
    
    
    @GetMapping("/books/new")
    public String booksNew(Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	Book newBook = new Book();
    	model.addAttribute("newBook", newBook);
    	return "new.jsp";
    }
    
    @PostMapping("/books/new")
    public String booksNewPost(@Valid @ModelAttribute("newBook") Book newBook,
    		BindingResult result, Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	if (result.hasErrors()) {
            return "new.jsp";
        } else {
        	newBook.setUser(loggedInUser);
            this.bookServ.addBook(newBook);
            return "redirect:/books";
        }
    }
    
    
    @GetMapping("/books/{id}/edit")
    public String booksIdEdit(@PathVariable("id") Long id,
    							Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	Book oldBook = this.bookServ.findOneBook(id);
    	model.addAttribute("oldBook", oldBook);
    	return "edit.jsp";
    }
    
    @PutMapping("/books/{id}/edit")
    public String booksIdEditPutt(@Valid @ModelAttribute("oldBook") Book oldBook,
    		BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	oldBook.setUser(loggedInUser);
    	if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	this.bookServ.editBook(oldBook);
            return "redirect:/books/" + oldBook.getId();
        }
    }
	
    
    @DeleteMapping("/books/{id}/delete")
    public String booksIdDelete(@PathVariable("id") Long id, Model model) {
    	this.bookServ.deleteBook(id);
    	return "redirect:/books";
    }
}