package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entity.Employee;
import com.employee.exception.ResourseNotFound;
import com.employee.helper.JwtUtil;
import com.employee.model.JwtRequest;
import com.employee.model.JwtResponse;
import com.employee.repository.EmployeeRepository;
import com.employee.services.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	public PasswordEncoder passwordEncoder;
    @Autowired
	public EmployeeRepository repository;
	@Autowired
	private AuthenticationManager authoticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
//    @RequestMapping("/welcome")
//    public String welcome()
//    {
// 	   String text ="this is private page";
// 	   text+="this page is not allowed to unauthenticated user";
//        return text;
//    }
//  
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//   	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest)throws Exception{
//       	System.out.println(jwtRequest);
//       	try {
//       		this.authoticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
//   			
//   		} catch (UsernameNotFoundException e) {
//   			e.printStackTrace();
//   			throw new Exception("Bad Credentials");
//   		}catch(BadCredentialsException e) {
//   			e.printStackTrace();
//   			throw new Exception("Bad Credentials");
//   		}
//       	UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
//       	String token = this.jwtUtil.generateToken(userDetails);
//    	System.out.println("Jwt"+token);
//    	return ResponseEntity.ok(new JwtResponse(token));
//       	}
//    
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
    	return repository.findAll();
    }
    
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
    	return repository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable int id){
    	Employee employee=repository.findById(id)
    			.orElseThrow(()-> new ResourseNotFound("no record found with this id:"+id));
    	return ResponseEntity.ok(employee);
    } 
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
    	Employee employee2=repository.findById(id)
    			.orElseThrow(()-> new ResourseNotFound("no record found with this id:"+id));
        employee2.setName(employee.getName());
        employee2.setUsername(employee.getUsername());
        employee2.setPassword(employee.getPassword());
        employee2.setStatus(employee.getStatus());
        Employee updateEmployee=repository.save(employee2);	
    	return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
    	Employee employee=repository.findById(id)
    			.orElseThrow(()-> new ResourseNotFound("no record found with this id:"+id));
    	repository.delete(employee);
    	Map<String, Boolean>response=new HashMap<>();
    	response.put("deleted",Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }
}
