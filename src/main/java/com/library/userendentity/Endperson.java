package com.library.userendentity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.book.Book;
import com.library.entity.Power;
import com.library.superentity.Super;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Endperson {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String token;
//	@OneToMany
////	@JoinTable(name="user_books",joinColumns=@JoinColumn(name="endperson_id"),
////	inverseJoinColumns=@JoinColumn(name="book_id"))
//	private Set<Book>assignedBooks=new HashSet<>();
////	private List<Book>book=new ArrayList<>();
	
	@ManyToOne
	private Power power;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sup_id")
	private Super sup;
	@OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> assignedBooks = new ArrayList<>();
	public Endperson(int id, String firstname, String lastname, String email, String password, String token,
			Power power, Super sup, List<Book> assignedBooks) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.token = token;
		this.power = power;
		this.sup = sup;
		this.assignedBooks = assignedBooks;
	}
	public Endperson() {
		super();
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
	public Super getSup() {
		return sup;
	}
	public void setSup(Super sup) {
		this.sup = sup;
	}
	public List<Book> getAssignedBooks() {
		return assignedBooks;
	}
	public void setAssignedBooks(List<Book> assignedBooks) {
		this.assignedBooks = assignedBooks;
	}
	
			
}
