package com.library.bookcategory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.bookcategory.Category;
import com.library.bookcategoryrepo.CategoryRepo;
import com.library.superRepository.SuperRepo;
import com.library.superentity.Super;
import com.library.superservice.Superinterface;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService implements CategoryInterface {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired 
	private Superinterface superinter;
	@Autowired
	private SuperRepo superRepo;
	 public Category getCategoryById(int categoryId) {
	        return categoryRepo.findById(categoryId)
	                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + categoryId));
	    }
	@Override
	public Super addcategory(Category category, int superid) throws Exception {
		// TODO Auto-generated method stub
		Super superAdmin = superRepo.findById(superid)
                .orElseThrow(() -> new RuntimeException("Super admin not found with ID: " + superid));
		superAdmin.getCategory().add(category);
		
		return superRepo.save(superAdmin);
	}
	@Override
	public List<Category> findallcategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}
	
	
	

}
