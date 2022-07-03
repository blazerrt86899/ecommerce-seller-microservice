package com.ecommerce.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.seller.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{

	Seller findByUsername(String username);

}
