package com.restapi.entities;

import jakarta.persistence.Entity;

@Entity
public class courses {
private String name;
private String username;
private long mobileno;
private long birthdate;
private int age;
public courses(String name, String username, long mobileno, int birthdate, int age) {
	super();
	this.name = name;
	this.username = username;
	this.mobileno = mobileno;
	this.birthdate = birthdate;
	this.age = age;
}
public courses() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public long getBirthdate() {
	return birthdate;
}
public void setBirthdate(long birthdate) {
	this.birthdate = birthdate;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "courses [name=" + name + ", username=" + username + ", mobileno=" + mobileno + ", birthdate=" + birthdate
			+ ", age=" + age + "]";
}

}
