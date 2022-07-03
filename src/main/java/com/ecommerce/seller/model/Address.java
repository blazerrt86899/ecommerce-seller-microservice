package com.ecommerce.seller.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller_address")
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	@Column
	private Integer houseNumber;
	@Column
	private String streetName;
	@Column
	private String locality;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private Integer pincode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId,Integer houseNumber, String streetName, String locality, String city, String state,
			Integer pincode) {
		
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}



}
