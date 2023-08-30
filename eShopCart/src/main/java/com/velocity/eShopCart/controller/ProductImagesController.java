package com.velocity.eShopCart.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velocity.eShopCart.model.ProductImages;
import com.velocity.eShopCart.repository.ProductImagesRepository;
import com.velocity.eShopCart.service.ProductImagesService;

@RestController
@RequestMapping("/file")
public class ProductImagesController {

	@Autowired
	private ProductImagesService imagesService;

	@Autowired
	private ProductImagesRepository imagesRepository;

	@Autowired
	private ObjectMapper mapper;

	private Logger logger = LoggerFactory.getLogger(ProductImagesController.class);

	/*
	 * @PostMapping("/save") public ResponseEntity<String>
	 * saveFile(@RequestParam("image") MultipartFile file) throws IOException {
	 * 
	 * try { String imagePath = imagesService.saveImagesToDirectory(file);
	 * ProductImages productImages = new ProductImages();
	 * productImages.setImagePath(imagePath); imagesRepository.save(productImages);
	 * return ResponseEntity.ok("Image Uploaded Successfully!!");
	 * 
	 * } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Failed to upload image"); }
	 * 
	 * }
	 */

	@PostMapping("/saveMultipleImages")
	public ResponseEntity<String> saveMultipleFiles(@RequestParam("images") List<MultipartFile> files) {

		logger.info("Save Multiple Images");

		try {
			List<String> imagePath = imagesService.saveMultipleImages(files);
			ProductImages productImages = new ProductImages();
			productImages.setImagePath(imagePath);
			imagesRepository.save(productImages);
			return ResponseEntity.ok("Files Uploaded Successfully ");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to upload files: " + e.getMessage());
		}

	}

	@PutMapping("/updateImages/{id}")
	public ResponseEntity<String> updateMultipleFiles(@RequestParam("images") List<MultipartFile> files,
			@PathVariable Integer id) throws IOException {

		logger.info("Update Images By id");
		Optional<ProductImages> images = imagesRepository.findById(id);

		if (images.isEmpty()) {
			return ResponseEntity.ok("Please select the file");
		}
		List<String> imagePath = imagesService.updateImagesToDirectory(files);
		ProductImages productImages1 = images.get();
		productImages1.setImagePath(imagePath);
		imagesRepository.save(productImages1);

		return ResponseEntity.ok("Image Updated Successfully!!");

	}

	@GetMapping("/getImagesData/{imageId}")
	public ResponseEntity<?> getImagesById(@PathVariable Integer imageId) {

		logger.info("Get Images Data By Id");

		ProductImages productImages = imagesService.getImageDataById(imageId);

		return ResponseEntity.ok().body(productImages);

	}

	@GetMapping("/getAllImageData")
	public ResponseEntity<List<ProductImages>> getAllData() {

		logger.info("Get all Image Data");

		List<ProductImages> imagesData = this.imagesService.getAllImageData();

		return ResponseEntity.ok().body(imagesData);

	}

	@DeleteMapping("/deleteImages/{imageId}")
	public ResponseEntity<String> deleteImagesById(@PathVariable Integer imageId) {

		logger.info("Delete Image Data By Id");

		imagesService.deleteImageById(imageId);

		return ResponseEntity.ok().body("Deleted Successfully!!");
	}

}
