package com.library.superentity;

import java.util.ArrayList;
import java.util.List;

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
	private String anothertoken;
	@ManyToOne
	private Power power;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Endperson>endperson=new ArrayList<>();
	
	public Super(int id, String firstname, String lastname, String email, String password, String token,
			String anothertoken, Power power, List<Endperson> endperson) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.token = token;
		this.anothertoken = anothertoken;
		this.power = power;
		this.endperson = endperson;
	}
	public Super() {
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
	public String getAnothertoken() {
		return anothertoken;
	}
	public void setAnothertoken(String anothertoken) {
		this.anothertoken = anothertoken;
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
		
}
