package com.velocity.eShopCart.service;

import java.util.List;

import com.velocity.eShopCart.model.SubCategory;

public interface SubCategoryService {

	public SubCategory addSubCategory(SubCategory subCategory);
	public SubCategory updateSubCategory(SubCategory subCategory);
	public SubCategory getSubCategory(long id);
	public List<SubCategory> getAllSubCategories();
	public void deleteSubCategory(long id);
	
}
