package com.library.bookrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.book.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

	List<Book> findByCategoryName(String categoryName);
//	List<Book>findAllByCategoryEquals(int categoryname);

	Iterable<Book> findAllByAssignedToIsNotNull();

}
