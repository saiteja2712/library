package com.library.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.library.bookcategory.Category;
import com.library.bookcategory.Service.CategoryInterface;
import com.library.bookcategoryrepo.CategoryRepo;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;

@RestController
public class CategoryController {
	@Autowired 
	private CategoryInterface categoryinter;
	@Autowired
	private Superinterface superinter;
	@Autowired 
	private CategoryRepo categoryRepo;
	@PostMapping("/categories")
	public Category addCategory(@RequestHeader("Authorization")String jwt,@RequestBody Category category) throws Exception 
	{
		
        	Super sup=superinter.findUserByJwt(jwt);
        	String var=sup.getToken();
        	if(jwt.substring(7).equals(var))
        	{
        		Category existingCategory = categoryRepo.findByName(category.getName());
                if (existingCategory != null) {
                    throw new Exception("Category with the same name already exists");
                }
        		Category categor = new Category();
        
        return categoryRepo.save(category);
        }
        	else
        {
        	throw new Exception ("failed");
        }
	}
	@GetMapping("/getallcategories")
	public List<Category>findallcategories(){
		return categoryinter.findallcategories();
		
	}
	
}
