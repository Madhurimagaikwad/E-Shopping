package com.velocity.eShopCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velocity.eShopCart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
