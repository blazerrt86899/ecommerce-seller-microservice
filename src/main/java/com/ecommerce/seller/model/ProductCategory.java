package com.ecommerce.seller.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	@Column
	private String categoryName;
	@Column
	private String briefAboutcategory;
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(Integer categoryId, String categoryName, String briefAboutcategory) {
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.briefAboutcategory = briefAboutcategory;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBriefAboutcategory() {
		return briefAboutcategory;
	}

	public void setBriefAboutcategory(String briefAboutcategory) {
		this.briefAboutcategory = briefAboutcategory;
	}
	
	
	

}
