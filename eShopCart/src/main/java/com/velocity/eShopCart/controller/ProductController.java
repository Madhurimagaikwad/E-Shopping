package com.velocity.eShopCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.eShopCart.exception.ResourceNotFoundException;
import com.velocity.eShopCart.model.Product;
import com.velocity.eShopCart.repository.ProductRepository;
import com.velocity.eShopCart.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product addProduct = productService.addProduct(product);
		return new ResponseEntity<>(addProduct, HttpStatus.OK);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId, null, productId));

		product.setProductName(updatedProduct.getProductName());
		product.setSubCategoryId(updatedProduct.getSubCategoryId());
		product.setProductDescription(updatedProduct.getProductDescription());
		product.setBrand(updatedProduct.getBrand());
		product.setProductCode(updatedProduct.getProductCode());
		product.setFeatured(updatedProduct.getFeatured());
		product.setSequence(updatedProduct.getSequence());

		Product updateProject = productRepository.save(product);
		return new ResponseEntity<>(updateProject, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product getProduct = productService.getProductById(id);
		return new ResponseEntity<Product>(getProduct, HttpStatus.OK);
	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Data Deleted Successfully..", HttpStatus.OK);
	}
}
