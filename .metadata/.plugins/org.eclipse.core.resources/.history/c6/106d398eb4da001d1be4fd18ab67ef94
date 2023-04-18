package com.employee.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.entity.CustomUserDetails;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;
                                              
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Employee employee=this.employeeRepository.findByUsername(username);
if (employee==null) {
	throw new UsernameNotFoundException("user not found");
}
else {
	return new CustomUserDetails(employee);
}
	}

}

//		if(username.equals("Gaurang")) {
//			return new User("Gaurang", "Gaurang2308", new ArrayList<>());
//		}else {
//			throw new UsernameNotFoundException("user not found ");
//		}