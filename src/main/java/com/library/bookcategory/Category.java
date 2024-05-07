package com.library.bookcategory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.bind.Name;

import com.library.book.Book;
import com.library.superentity.Super;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany
	private List<Book>book=new ArrayList<>();
	@ManyToOne
	private Super sup;
	public Category(int id, String name, List<Book> book, Super sup) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
		this.sup = sup;
	}
	public Category() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public Super getSup() {
		return sup;
	}
	public void setSup(Super sup) {
		this.sup = sup;
	}
	
}
