package com.restapi.services;

import java.util.List;

import com.restapi.entities.courses;

public interface courseservice {
	void deletecourse(String name);
 public List<courses>getcourses();
 public courses addCourse(courses course);
 public courses updateCourse(courses course);
}
 