package com.ecommerce.seller.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "product_subcategory")
public class ProductSubCategory implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcategory_id")
	private Integer subCategoryId;
	@Column
	private String subCategoryName;
	@ManyToOne
	@JoinColumn(name = "category_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ProductCategory category;
	@Column
	private String briefCategoryDetail;
	@Column
	private Double gSTPercentage;
	
	public ProductSubCategory() {
		// TODO Auto-generated constructor stub
	}

	public ProductSubCategory(Integer subCategoryId, String subCategoryName, ProductCategory category,
			String briefCategoryDetail, Double gSTPercentage) {
		
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
		this.briefCategoryDetail = briefCategoryDetail;
		this.gSTPercentage = gSTPercentage;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getBriefCategoryDetail() {
		return briefCategoryDetail;
	}

	public void setBriefCategoryDetail(String briefCategoryDetail) {
		this.briefCategoryDetail = briefCategoryDetail;
	}

	public Double getgSTPercentage() {
		return gSTPercentage;
	}

	public void setgSTPercentage(Double gSTPercentage) {
		this.gSTPercentage = gSTPercentage;
	}
	
	
	
	
}
