package com.ecommerce.seller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.seller.model.Seller;
import com.ecommerce.seller.service.SellerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping(value = "/signup",produces = "application/json")
	public Seller addNewSeller(@RequestBody Seller seller) {
		return sellerService.addSeller(seller);
	}
	
	@GetMapping(value = "/get/{bid}")
	public Seller getSeller(@PathVariable("bid") Integer sellerId) {
		return sellerService.getSellerById(sellerId);
	}

}
