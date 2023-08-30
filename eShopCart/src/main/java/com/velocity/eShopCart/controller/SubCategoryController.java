package com.velocity.eShopCart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.eShopCart.model.Category;
import com.velocity.eShopCart.model.SubCategory;
import com.velocity.eShopCart.service.CategoryService;
import com.velocity.eShopCart.service.SubCategoryService;


@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subcategoryService;
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<SubCategory> addSubCategory(@RequestBody SubCategory subCategory) {
		
			
		int catId = subCategory.getCategory().getId();
			
		Optional<Category> category = categoryService.getCategoryById(catId);
			
		if(category.isPresent()) {
			Category category2 = category.get();
			subCategory.setCategory(category2);
			return ResponseEntity.ok().body(this.subcategoryService.addSubCategory(subCategory));
		}
		else {
			 return ResponseEntity.badRequest().build();
		}
		
	}

	@PutMapping("/modify")
	public ResponseEntity<SubCategory> modifySubCategory(@RequestBody SubCategory subCategory) {
		SubCategory updatedSubCategory = this.subcategoryService.updateSubCategory(subCategory);
		return ResponseEntity.ok().body(updatedSubCategory);
	}

	
	@GetMapping("/getById/{id}")
	public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long subid){
		SubCategory subCategory = this.subcategoryService.getSubCategory(subid);
		return ResponseEntity.ok().body(subCategory);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<SubCategory>> getAllSubCategories(){
		return ResponseEntity.ok().body(this.subcategoryService.getAllSubCategories());
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSubCategory(@PathVariable Long id){
		
		Optional<SubCategory> sub =Optional.of(this.subcategoryService.getSubCategory(id));
		if(sub.isPresent()) {
			this.subcategoryService.deleteSubCategory(id);
			return ResponseEntity.ok().body("Deleted Successfully");
		}
		else
		{
			return ResponseEntity.ok().body("Id not present");
		}
	}
}
