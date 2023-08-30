package com.velocity.eShopCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velocity.eShopCart.model.ProductPrice;




@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer>{

}
