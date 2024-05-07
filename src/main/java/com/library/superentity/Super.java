package com.library.superentity;

import java.util.ArrayList;
import java.util.List;

import com.library.book.Book;
import com.library.bookcategory.Category;
import com.library.entity.Power;
import com.library.userendentity.Endperson;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table

public class Super {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String token;
	@ManyToOne
	private Power power;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Endperson>endperson=new ArrayList<>();
	@OneToMany
	private List<Book>book=new ArrayList<>();
	@OneToMany
	private List<Category>category=new ArrayList<>();
	public Super(int id, String firstname, String lastname, String email, String password, String token,
			 Power power, List<Endperson> endperson, List<Book> book,List<Category> category) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.token = token;
		this.power = power;
		this.endperson = endperson;
		this.book = book;
		this.category=category;
	}
	public Super() {
		super();
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public List<Endperson> getEndperson() {
		return endperson;
	}
	public void setEndperson(List<Endperson> endperson) {
		this.endperson = endperson;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
			
}
