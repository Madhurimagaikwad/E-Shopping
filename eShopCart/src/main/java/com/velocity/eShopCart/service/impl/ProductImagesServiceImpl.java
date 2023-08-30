package com.velocity.eShopCart.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.velocity.eShopCart.controller.ProductImagesController;
import com.velocity.eShopCart.model.ProductImages;
import com.velocity.eShopCart.repository.ProductImagesRepository;
import com.velocity.eShopCart.service.ProductImagesService;

@Service
public class ProductImagesServiceImpl implements ProductImagesService {

	@Autowired
	private ProductImagesRepository imagesRepository;

	private Logger logger = LoggerFactory.getLogger(ProductImagesController.class);

	@Override
	public String saveImagesToDirectory(MultipartFile file) throws IOException { // for storing single file only

		logger.info("Product Images save implementation");

		final String imagePath = new ClassPathResource("/images").getFile().getAbsolutePath();

		Files.copy(file.getInputStream(), Paths.get(imagePath + File.separator + file.getOriginalFilename()),
				StandardCopyOption.REPLACE_EXISTING);

		return imagePath;

	}

	@Override
	public List<String> saveMultipleImages(List<MultipartFile> files) throws IOException { // for storing multiple files

		logger.info("ProductImages save multiple files implementation");

		List<String> imagePath = new ArrayList<>();

		for (MultipartFile file : files) {

			final String filePath = new ClassPathResource("/images").getFile().getAbsolutePath();

			Files.copy(file.getInputStream(), Paths.get(filePath + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			imagePath.add(filePath);

		}
		return imagePath;

	}

	@Override
	public List<String> updateImagesToDirectory(List<MultipartFile> files) throws IOException {

		logger.info("ProductImages update implementation");
		List<String> imagePath = new ArrayList<>();

		for (MultipartFile file : files) {

			final String filePath = new ClassPathResource("/images").getFile().getAbsolutePath();

			Files.copy(file.getInputStream(), Paths.get(filePath + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			imagePath.add(filePath);

		}
		return imagePath;

	}

	@Override
	public ProductImages getImageDataById(Integer imageId) {
		logger.info("ProductImages get implementation");
		Optional<ProductImages> prOptional = imagesRepository.findById(imageId);
		if (prOptional.isPresent()) {
			ProductImages productImages = prOptional.get();
			productImages.getImageId();
			productImages.getProductId();
			productImages.getImagePath();
			return productImages;
		} else {
			return null;
		}

	}

	@Override
	public List<ProductImages> getAllImageData() {
		logger.info("ProductImages get all implementation");
		return this.imagesRepository.findAll();
	}

	@Override
	public void deleteImageById(Integer imageId) {
		logger.info("ProductImages delete by id implementation");
		imagesRepository.deleteById(imageId);

	}

}
