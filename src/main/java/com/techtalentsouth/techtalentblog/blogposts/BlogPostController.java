package com.techtalentsouth.techtalentblog.blogposts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostController {
	
	@GetMapping(path="/")	
	public String index(Model model) {
		BlogPost defaultValue = new BlogPost("How to Use SpringBoot",
				                             "Scott Dossey",
				                             "Just pay a real developer to do it for you");
		//Model is a lot like a hashmap
		//is stores keys value pairs....but they keys
		//are always string variable names.
		model.addAttribute("blogPost", defaultValue);
		return "blogpost/index";
	}
		
}
