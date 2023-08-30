package com.velocity.eShopCart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velocity.eShopCart.model.Category;
import com.velocity.eShopCart.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {

	private Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategoryDetails(@RequestParam("file") MultipartFile file,

			@RequestParam("categoryData") String categoryData) throws IOException {

		logger.info("add category Details");

		logger.info("category :", categoryData);
		Category category = mapper.readValue(categoryData, Category.class);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		category.setImageName(fileName);
		try {

			final String UPLOAD_DIR = Paths.get("src/main/resources/images").toAbsolutePath().toString();

			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Category category2 = categoryService.saveCategoryDetails(category);

		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
				.path(file.getOriginalFilename()).toUriString());
		return ResponseEntity.ok().body(category2);
	}

	@GetMapping("/get/{id}")
	public Optional<Category> getCategoryById(@PathVariable Integer id) {
		if (id == null) {
			throw new NullPointerException("The given id is null or not present");
		} else {
			return categoryService.getCategoryById(id);
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCategoryById(@PathVariable int id) throws IOException {

		categoryService.deleteCategoryById(id);

		return "specified id deleted successfully ";

	}

	@GetMapping("/list")
	public List<Category> getCategoryList() {
		return categoryService.getCategoryList();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Category> updateCategoryDetails(@RequestParam("file") MultipartFile file,
			@RequestParam("categoryData") String categoryData, @PathVariable int id) throws IOException {

		logger.info("update category Details");

		logger.info("category:{}", categoryData);

		Category category = mapper.readValue(categoryData, Category.class);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		category.setId(category.getId());
		category.setCategoryname(category.getCategoryname());
		category.setDescription(category.getDescription());
		category.setCreatedBy(category.getCreatedBy());
		category.setImageName(fileName);

		Category category2 = categoryService.saveCategoryDetails(category);

		return ResponseEntity.ok().body(category2);

	}

}
