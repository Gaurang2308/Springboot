package com.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.coursedao;
import com.restapi.entities.courses;
@Service
public class courseserviceimpl implements courseservice {
 
	@Autowired
	
	private coursedao courseDao;
//	List<courses> list;
	 public courseserviceimpl() {}
		 

	  
	
	
	
	@Override	
	public List<courses> getcourses() {
//		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	
	public courses getcourse(String coursename) {
		return courseDao.getOne(coursename);
	}



	@Override
	public courses addCourse(courses course) {
//		list.add(course);
		courseDao.save(course); 
		return course;
	}
		// TODO Auto-generated method stub



	@Override
	public void deletecourse(String name) {
//		// TODO Auto-generated method stub
//		 list.removeIf(courses -> courses.getName().equals(name));
		courses entity = courseDao.getOne(toString());
		courseDao.delete(entity);
	}



	@Override
	public courses updateCourse(courses course) {
//		list.forEach(e->{
//			if(e.getName()==course.getName()) {
//				e.setUsername(course.getUsername());
//				e.setName(course.getName());
//				e.setAge(course.getAge());
//				e.setBirthdate(course.getBirthdate());
//				e.setMobileno(course.getMobileno());
//			}
//		});
		
	  courseDao.save(course);
		return course;
	}

	
}







