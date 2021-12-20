package com.codingdojo.OmikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
		
	@GetMapping("")
	public String index() {
		return "redirect:/omikuji";
	}
	
    @GetMapping("/omikuji")
    public String omikuji(Model model) {
    	
    	return "index.jsp";
    }
    
    @GetMapping("/omikuji/show")
    public String omikujiShow(Model model, HttpSession session) {
    	model.addAttribute("number", session.getAttribute("number"));
    	model.addAttribute("city", session.getAttribute("city"));
    	model.addAttribute("name", session.getAttribute("name"));
    	model.addAttribute("hobby", session.getAttribute("hobby"));
    	model.addAttribute("livingThing", session.getAttribute("livingThing"));
    	model.addAttribute("compliment", session.getAttribute("compliment"));
    	return "show.jsp";
    }
        
    @RequestMapping(value="/omikuji/post", method=RequestMethod.POST)
    public String omikujiPost(
    		@RequestParam(value="number") Integer number,
    		@RequestParam(value="city") String city,
    		@RequestParam(value="name") String name,
    		@RequestParam(value="hobby") String hobby,
    		@RequestParam(value="livingThing") String livingThing,
    		@RequestParam(value="compliment") String compliment,
    		HttpSession session) {
    	session.setAttribute("number", number);
    	session.setAttribute("city", city);
    	session.setAttribute("name", name);
    	session.setAttribute("hobby", hobby);
    	session.setAttribute("livingThing", livingThing);
    	session.setAttribute("compliment", compliment);
	
        return "redirect:/omikuji/show";
    }
}