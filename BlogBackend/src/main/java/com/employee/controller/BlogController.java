package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Blog;
import com.employee.exception.ResourcenotFound;

import com.employee.repository.BlogRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {
	@Autowired
	public BlogRepository repository;
    
    @GetMapping("/Blogs")
    public List<Blog> getAllBlog(){
    	return repository.findAll();
    }
    
    @PostMapping("/Blogs")
    public Blog saveBlog(@RequestBody Blog blog) {
    	return repository.save(blog);
    }
    @GetMapping("/Blogs/{username}")
    public ResponseEntity<List<Blog>> getBlogByUsername(@PathVariable("username") String username){
    	List<Blog> blog=repository.findAllByUsername(username);
    	System.out.println(blog);
    	return ResponseEntity.ok(blog);
    }
    @PutMapping("/Blogs/{Id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int Id,@RequestBody Blog blog){
    	Blog blog2=repository.findById(Id);
    	blog2.setTitle(blog.getTitle());
        blog2.setDiscription(blog.getDiscription());
        blog2.setUrl(blog.getUrl());
        Blog updateBlog=repository.save(blog2);	
    	return ResponseEntity.ok(updateBlog);
    }
    @DeleteMapping("Blogs/{Id}")
    public ResponseEntity<Map<String, Boolean>> deleteBlog(@PathVariable int Id){
    	Blog blog=repository.findById(Id);
    	Map<String, Boolean>response=new HashMap<>();
    	response.put("deleted",Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }

}
