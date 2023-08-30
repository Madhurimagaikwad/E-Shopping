package com.velocity.eShopCart.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velocity.eShopCart.model.Category;
import com.velocity.eShopCart.repository.CategoryRepository;
import com.velocity.eShopCart.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {
	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategoryDetails(Category category) {
		logger.info("Category save Implementation");
		Category category2 = categoryRepository.save(category);
		return category2;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Category> getCategoryById(int id) {
		if (id !=0) {
			return categoryRepository.findById(id);
		}else {
			throw new NullPointerException("The given id is null or not present");
		}

	}

	@Override
	public void deleteCategoryById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);

		if (category != null) {
			deleteImage(category.getImageName());
			categoryRepository.delete(category);
		} else {
			throw new NullPointerException("The given id is null or not present");
		}
	}

	private void deleteImage(String ImageName) {
		if (ImageName != null) {
			try {

				final String UPLOAD_DIR = Paths.get("src/main/resources/images").toAbsolutePath().toString();
				Path imageFilePath = Paths.get(UPLOAD_DIR + ImageName);
				Files.deleteIfExists(imageFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepository.findAll();
	}

}
