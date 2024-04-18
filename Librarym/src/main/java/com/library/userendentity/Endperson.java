package com.library.userendentity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.entity.Power;
import com.library.superentity.Super;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
	private Power power;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sup_id")
	private Super sup;
	public Endperson(int id, String firstname, String lastname, String email, String password, Power power, Super sup) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.power = power;
		this.sup = sup;
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
	@Override
	public String toString() {
		return "Endperson [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", power=" + power + ", sup=" + sup + "]";
	}
	
}
