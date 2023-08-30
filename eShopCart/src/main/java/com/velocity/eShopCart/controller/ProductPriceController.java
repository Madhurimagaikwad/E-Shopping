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

import com.velocity.eShopCart.model.ProductPrice;
import com.velocity.eShopCart.service.ProductPriceService;




@RestController
@RequestMapping("/ProductPrice")
public class ProductPriceController {
	@Autowired
	private ProductPriceService productPriceService;

	@PostMapping("/addProductPrice")
	public ProductPrice addProductPrice(@RequestBody ProductPrice productPrice) {
		ProductPrice productPrice1 = productPriceService.addProductPrice(productPrice);
		return productPrice1;
	}

	@GetMapping("/getProductPrice/{id}")
	public ResponseEntity<Optional<ProductPrice>> getById(@PathVariable Integer id) {
		Optional<ProductPrice> productPrice2 = productPriceService.getById(id);

		return ResponseEntity.ok(productPrice2);

	}

	@GetMapping("/getAllProductDetails")

	public List<ProductPrice> getAllPrice() {

		List<ProductPrice> productPrice3 = productPriceService.getAllProductPriceData();
		return productPrice3;

	}

	@DeleteMapping("/deleteProductPrice/{id}")
	public void deleteById(@PathVariable Integer id) {

		productPriceService.deleteById(id);
	}
	
	@PutMapping("/updateProductPrice/{id}")
	public ResponseEntity<ProductPrice> updateProductPrice(@PathVariable("id") int id, @RequestBody ProductPrice productPrice) {
	
		ProductPrice productPrice4 = productPriceService.updateProductPrice(id, productPrice);
		return ResponseEntity.ok().body(productPrice4);
		
//		 public ResponseEntity<String> updatePrice(@PathVariable int priceId, @RequestBody Price updatedPrice) {
//		        // Assuming PriceService has a method to update the price
//		        boolean updated = priceService.updatePrice(priceId, updatedPrice);
//		        if (updated) {
//		            return ResponseEntity.ok("Price updated successfully");
//		        } else {
//		            return ResponseEntity.notFound().build();
//		        }
	}
}
