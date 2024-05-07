package com.library.book.service;

import java.util.List;

import com.library.book.Book;

public interface Bookinterface {
//	public Book insert(Book book);
	public List<Book>findall();
	public void assignBook(int endpersonId, int bookId);
	public void assignBook(int bookId);
	public void bookemailassign(String email,int bookId);
//	public void releaseBook(int endpersonId,int bookId);
	public void releaseBook(int endpersonId,int bookId);
	public void releaseBooks(String email,int bookId);
	public Iterable<Book> getAllAssignedBooks();
//	public Iterable<Book> getAssignedBooksForUser(int endpersonId);
	public Iterable<Book>getAssignedBooksForUser(String email);
	//public Book addBook(String title, String author, int publishedYear, String imageofbook, Long categoryId);
//public Book addBook(String title, String author, String publishedYear, String imageofbook, int categoryId);

}
