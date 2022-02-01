package com.codingdojo.javaexam.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.javaexam.models.Show;
import com.codingdojo.javaexam.models.LoginUser;
import com.codingdojo.javaexam.models.User;
import com.codingdojo.javaexam.services.ShowService;
import com.codingdojo.javaexam.services.UserService;



@Controller
public class HomeController {
	
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private ShowService showServ;
    
   
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") != null) {		
    		return "redirect:/shows";					
    	}
    	
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @GetMapping("/shows")
    public String dashboard(Model model, HttpSession session) {
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	User loggedInUser = this.userServ.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	List<Show> showList = this.showServ.allShows();
    	model.addAttribute("showList", showList);
    	return "dashboard.jsp";
    }
    
    

    @PutMapping("/")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/shows";
    }
    

    @PostMapping("/")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/shows";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();					
    	return "redirect:/";					
    }
}