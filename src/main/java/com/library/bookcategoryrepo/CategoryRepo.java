package com.library.bookcategoryrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.library.bookcategory.Category;
import java.util.List;


@Service
public interface CategoryRepo extends JpaRepository<Category,Integer>{
	Category findByName(String name);
	//List<Category> findByName(String name);
}
