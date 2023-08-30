package com.velocity.eShopCart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.velocity.eShopCart.model.Category;
import com.velocity.eShopCart.model.SubCategory;
import com.velocity.eShopCart.repository.SubCategoryRepository;
import com.velocity.eShopCart.service.SubCategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@Override
	public SubCategory addSubCategory(SubCategory subCategory) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String createdBy = authentication.getName();
        subCategory.setcreatedBy(createdBy);
		
		return this.subCategoryRepository.save(subCategory);
	}

	@SuppressWarnings("deprecation")
	@Override
	public SubCategory updateSubCategory(SubCategory subCategory) {
		
		// need to do some changes 
		 Integer subCategoryId = (Integer) subCategory.getSubCategoryId();
		    Optional<SubCategory> retrievedSubCategory = subCategoryRepository.findById(subCategoryId);
		    
		    if(retrievedSubCategory == null) {
		    	 throw new EntityNotFoundException("SubCategory not found with ID: " + subCategoryId);
		    }
		
		SubCategory retrivedSubCategory = this.subCategoryRepository.getById(subCategory.getSubCategoryId());
		
		retrivedSubCategory.setCategory(subCategory.getCategory());
		retrivedSubCategory.setCreateddate(subCategory.getCreateddate());
		retrivedSubCategory.setcreatedBy(subCategory.getCreayedBy());
		retrivedSubCategory.setDescription(subCategory.getDescription());
		retrivedSubCategory.setSubCategoryId(subCategory.getSubCategoryId());
		retrivedSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
		
		SubCategory savedSubCategory = subCategoryRepository.save(retrivedSubCategory);
		
		return savedSubCategory;
	}

	@SuppressWarnings("deprecation")
	@Override
	public SubCategory getSubCategory(long id) {

		return this.subCategoryRepository.getById((int) id);
	}

	@Override
	public List<SubCategory> getAllSubCategories() {
		return this.subCategoryRepository.findAll();
	}

	@Override
	public void deleteSubCategory(long id) {
		this.subCategoryRepository.deleteById((int) id);
	}

}
