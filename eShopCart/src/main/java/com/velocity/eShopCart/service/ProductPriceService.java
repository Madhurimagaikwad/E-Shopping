package com.velocity.eShopCart.service;

import java.util.List;
import java.util.Optional;

import com.velocity.eShopCart.model.ProductPrice;




public interface ProductPriceService {
	//add the price
		public ProductPrice addProductPrice(ProductPrice productPrice);

	//get by id	
	    public Optional<ProductPrice> getById(Integer id);

	//get all data
	    public List<ProductPrice> getAllProductPriceData();

	//delete by id
	    public void deleteById(Integer id);
	    
	//update by id
	    public ProductPrice updateProductPrice(int id, ProductPrice productPrice);
}
