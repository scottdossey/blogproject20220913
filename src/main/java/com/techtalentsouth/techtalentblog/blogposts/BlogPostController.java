package com.techtalentsouth.techtalentblog.blogposts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	//In memory copy of the database.
	private List<BlogPost> posts = new ArrayList<>(); 
	
	@GetMapping(path="/")	
	public String index(Model model) {

		model.addAttribute("posts", posts);
		return "blogpost/index";
	}

	@GetMapping(path="/blogposts/new")
	public String newBlog(Model model) {
		BlogPost defaultValue = new BlogPost();
		//Model is a lot like a hashmap
		//is stores keys value pairs....but they keys
		//are always string variable names.
		model.addAttribute("blogPost", defaultValue);
		return "blogpost/new";
	}
	
	@PostMapping(path="/blogposts")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		BlogPost result = blogPostRepository.save(blogPost);	
		posts.add(result);
		
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
	
		
}
