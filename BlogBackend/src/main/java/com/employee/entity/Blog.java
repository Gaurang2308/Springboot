package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Blog11")


@ToString
@NoArgsConstructor
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", discription=" + discription + ", url=" + url + ", username="
				+ username + "]";
	}
	@Column
    private String title;
	@Column
    private String discription;
 	@Column
    private String url;
 	@Column
 	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Blog(int id, String title, String discription, String url, String username) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.url = url;
		this.username = username;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 	
	
}
