package com.velocity.eShopCart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velocity.eShopCart.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Double> {

	Optional<UserInfo> findByUsername(String username);	

}
