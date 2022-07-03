package com.ecommerce.seller.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "seller")
public class Seller implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id")
	private Integer sellerId;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String companyName;
	@Column
	private Double gSTIN;
	@Column
	private String briefAboutCompany;
	@OneToOne
	@JoinColumn(name = "seller_address_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Address postalAddress;
	@Column
	private String website;
	@Column
	private String emailId;
	@Column
	private String contactNumber;
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}

	public Seller(Integer sellerId, String username, String password, String companyName, Double gSTIN,
			String briefAboutCompany, Address postalAddress, String website, String emailId, String contactNumber) {
		
		this.sellerId = sellerId;
		this.username = username;
		this.password = password;
		this.companyName = companyName;
		this.gSTIN = gSTIN;
		this.briefAboutCompany = briefAboutCompany;
		this.postalAddress = postalAddress;
		this.website = website;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getgSTIN() {
		return gSTIN;
	}
	public void setgSTIN(Double gSTIN) {
		this.gSTIN = gSTIN;
	}

	public String getBriefAboutCompany() {
		return briefAboutCompany;
	}

	public void setBriefAboutCompany(String briefAboutCompany) {
		this.briefAboutCompany = briefAboutCompany;
	}

	public Address getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(Address postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	
	

}
