package com.velocity.eShopCart.service;

import java.util.List;
import java.util.Optional;

import com.velocity.eShopCart.model.Category;

public interface CategoryService {

	public Category saveCategoryDetails(Category category);

	public Optional<Category> getCategoryById(int id);

	public void deleteCategoryById(int id);

	public List<Category> getCategoryList();

}
