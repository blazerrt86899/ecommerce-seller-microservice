package com.ecommerce.seller.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.seller.model.Seller;
import com.ecommerce.seller.repository.AddressRepository;
import com.ecommerce.seller.repository.SellerRepository;

@Service
public class SellerService implements UserDetailsService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public Seller addSeller(Seller seller) {
		addressRepository.save(seller.getPostalAddress());
		seller.setPassword(bcryptEncoder.encode(seller.getPassword()));
		return sellerRepository.save(seller);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Seller seller = sellerRepository.findByUsername(username);
		if(seller == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(seller.getUsername(), seller.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public Seller findOne(String username) {
		
		return sellerRepository.findByUsername(username);
	}

	public Seller getSellerById(Integer sellerId) {
		Optional<Seller> seller = sellerRepository.findById(sellerId);
		return seller.get();
	}

	

}
