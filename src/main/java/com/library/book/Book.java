package com.library.book;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.bookcategory.Category;
import com.library.superentity.Super;
import com.library.userendentity.Endperson;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table
@Builder
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String titleofbook;
	private String author;
	private String publishyear;
	@Lob
	private byte[] imageofbook;
	@ManyToOne
	private Super sup;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endperson_id")
	private Endperson assignedTo;
//	@ManyToMany(mappedBy = "assignedBooks")
//    private Set<Endperson> assignedToUsers = new HashSet<>();
//	@ManyToOne
//	@JoinColumn(name="endperson_id")
//	private Endperson assignedToEndperson;
	@ManyToOne
	@JoinColumn(name="category_name")
	private Category category;
public Book(int id, String titleofbook, String author, String publishyear, byte[] imageofbook, Super sup,
		Endperson assignedTo, Category category) {
	super();
	this.id = id;
	this.titleofbook = titleofbook;
	this.author = author;
	this.publishyear = publishyear;
	this.imageofbook = imageofbook;
	this.sup = sup;
	this.assignedTo = assignedTo;
	this.category = category;
}
public Book() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitleofbook() {
	return titleofbook;
}
public void setTitleofbook(String titleofbook) {
	this.titleofbook = titleofbook;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublishyear() {
	return publishyear;
}
public void setPublishyear(String publishyear) {
	this.publishyear = publishyear;
}
public byte[] getImageofbook() {
	return imageofbook;
}
public void setImageofbook(byte[] imageofbook) {
	this.imageofbook = imageofbook;
}
public Super getSup() {
	return sup;
}
public void setSup(Super sup) {
	this.sup = sup;
}
public Endperson getAssignedTo() {
	return assignedTo;
}
public void setAssignedTo(Endperson assignedTo) {
	this.assignedTo = assignedTo;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
		
}
