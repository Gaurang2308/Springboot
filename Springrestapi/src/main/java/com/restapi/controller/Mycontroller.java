package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.courses;
import com.restapi.services.courseservice;
@RestController
public class Mycontroller {
	@Autowired
	private courseservice courseservice;
	@GetMapping("/home")
public String home() {
	return("this is home page");
}
	@GetMapping("/courses")
	public List<courses>getcourses(){
		return this.courseservice.getcourses();
	}
	@PostMapping("/courses")
    public courses addCourse(@RequestBody courses course) {

	return this.courseservice.addCourse(course);
	}
		@PutMapping("/courses")
		public courses updateCourse(@RequestBody courses course) {
			return this.courseservice.updateCourse(course);
		}
	
	
	@DeleteMapping("/courses/{name}")	
	public ResponseEntity<HttpStatus> deletecourse(@PathVariable String name){
		courseservice.deletecourse(name);
		return ResponseEntity.ok().build();
		
	}

}
