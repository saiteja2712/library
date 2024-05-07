package com.library.bookcategory.Service;

import java.util.List;

import com.library.bookcategory.Category;
import com.library.superentity.Super;

public interface CategoryInterface {
	public Category getCategoryById(int categoryId);
	public Super addcategory(Category category,int superid) throws Exception;
	///downline
	public List<Category>findallcategories();

}
