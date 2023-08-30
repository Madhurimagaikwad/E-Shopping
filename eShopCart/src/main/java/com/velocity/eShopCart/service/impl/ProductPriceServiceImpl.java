package com.velocity.eShopCart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velocity.eShopCart.model.ProductPrice;
import com.velocity.eShopCart.repository.ProductPriceRepository;
import com.velocity.eShopCart.service.ProductPriceService;


@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	@Override
	public ProductPrice addProductPrice(ProductPrice productPrice) {
		return productPriceRepository.save(productPrice);
	}

	@Override
	public Optional<ProductPrice> getById(Integer id) {
		return productPriceRepository.findById(id);
	}

	@Override
	public List<ProductPrice> getAllProductPriceData() {
		return productPriceRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		if (id != null) {
			productPriceRepository.deleteById(id);
			
		} else {
			throw new NullPointerException("the given id is null or not present");
		}
		
	}

	@Override
	public ProductPrice updateProductPrice(int id, ProductPrice productPrice) {
		ProductPrice pr=this.productPriceRepository.getById(id);
//		ProductPrice pr1=null;
//		if(pr==null) {
//			throw new NullPointerException("The Given Id is Null");
//		}else {
			//pr.setProduct(productPrice.g);
			pr.setRegularPrice(productPrice.getRegularPrice());
			pr.setSellPrice(productPrice.getSellPrice());
			pr.setUnit(productPrice.getUnit());
			pr.setDeleted(false);
//		}
		return pr;
	}

}
