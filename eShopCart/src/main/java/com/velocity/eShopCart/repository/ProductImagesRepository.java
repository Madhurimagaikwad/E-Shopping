package com.velocity.eShopCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.velocity.eShopCart.model.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer> {

}
