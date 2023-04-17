package com.employee.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findAllByUsername(String username);
       Blog findById(int Id);
	
}
