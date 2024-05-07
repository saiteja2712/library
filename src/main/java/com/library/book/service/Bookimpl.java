package com.library.book.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.library.book.Book;
import com.library.bookcategory.Category;
import com.library.bookcategoryrepo.CategoryRepo;
import com.library.bookrepo.BookRepo;
import com.library.userendRepository.Endrepo;
import com.library.userendentity.Endperson;
import com.library.userendservice.Endpersoninterface;

import jakarta.persistence.EntityNotFoundException;
@Service
public class Bookimpl implements Bookinterface {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private CategoryRepo categoryrepo;
	@Autowired
	private Endrepo endrepo;
	@Autowired
	private Endpersoninterface endinter;

//	@Override
//	public Book insert(Book book) {
//		// TODO Auto-generated method stub
//		return bookRepo.save(book);
//	}

	@Override
	public List<Book> findall() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}
//	@Override
//	public Book addBook(String title, String author, String publishedYear, String imageofbook, int categoryId) {
//        Category category = categoryrepo.findById(categoryId)
//                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
//
//        Book book = new Book();
//        book.setTitleofbook(title);
//        book.setAuthor(author);
//        book.setPublishyear(publishedYear);
//        book.setImageofbook(imageofbook);
//        book.setCategory(category);
//        return  bookRepo.save(book);
//
//}
	public void assignBook(int endpersonId, int bookId) {
        Endperson user = endrepo.findById(endpersonId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (book.getAssignedTo() != null) {
            throw new IllegalStateException("Book is already assigned to a user");
        }

        book.setAssignedTo(user);
        user.getAssignedBooks().add(book);
        endrepo.save(user);
    }
	public void bookemailassign(String email,int bookId)
	{
		Endperson end=endrepo.findByEmail(email);
		Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
		if (book.getAssignedTo() != null) {
            throw new IllegalStateException("Book is already assigned to a user");
        }
		book.setAssignedTo(end);
		end.getAssignedBooks().add(book);
		endrepo.save(end);


	}
	@Override
	public void releaseBooks(String email, int bookId) {
		Endperson end=endrepo.findByEmail(email);
		Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
		if (!book.getAssignedTo().equals(end)) {
	        throw new IllegalStateException("You can only release your own assigned books");
	    }
		end.getAssignedBooks().remove(book);
	    book.setAssignedTo(null);
	    endrepo.save(end);
		// TODO Auto-generated method stub
		
	}

	public void releaseBook(int endpersonId, int bookId) {
	    Endperson user = endrepo.findById(endpersonId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));
	    Book book = bookRepo.findById(bookId)
	            .orElseThrow(() -> new IllegalArgumentException("Book not found"));

	    if (!book.getAssignedTo().equals(user)) {
	        throw new IllegalStateException("You can only release your own assigned books");
	    }

	    user.getAssignedBooks().remove(book);
	    book.setAssignedTo(null);
	    endrepo.save(user);
	}

    public Iterable<Book> getAllAssignedBooks() {
        return bookRepo.findAllByAssignedToIsNotNull();
    }
//    public Iterable<Book> getAssignedBooksForUser(int endpersonId) {
//       Endperson user = endrepo.findById(endpersonId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//        return user.getAssignedBooks();
//    }
    @Override
	public Iterable<Book> getAssignedBooksForUser(String email) {
		// TODO Auto-generated method stub
    	Endperson end=endrepo.findByEmail(email);
    	
		return end.getAssignedBooks();
	}
	
	@Override
	public void assignBook(int bookId) {
		Endperson user=new Endperson();
		
		
			 Book book = bookRepo.findById(bookId)
			            .orElseThrow(() -> new IllegalArgumentException("Book not found"));

//			    if (!book.getAssignedTo().equals(user)) {
//			        throw new IllegalStateException("You can only release your own assigned books");
//			    }
			 if (book.getAssignedTo() != null) {
		            throw new IllegalStateException("Book is already assigned to a user");
		        }

//			    user.getAssignedBooks().add(book);
//			    book.setAssignedTo(null);
//			    endrepo.save(user);
		}
		// TODO Auto-generated method stub
	
		
	}
	

	
	

