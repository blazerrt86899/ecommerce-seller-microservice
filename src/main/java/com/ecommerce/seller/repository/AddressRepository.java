package com.ecommerce.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.seller.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
