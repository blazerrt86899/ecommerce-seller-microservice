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
@Table(name = "item_table_seller")
public class ItemInventory implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Integer itemId;
	@ManyToOne
	@JoinColumn(name = "seller_id_fk")
	private Seller sellerId;
	@ManyToOne
	@JoinColumn(name = "category_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ProductCategory category;
	@ManyToOne
	@JoinColumn(name = "subcategory_id_fk")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ProductSubCategory subcategory;
	@Column
	private Double itemCost;
	@Column
	private String itemName;
	@Column
	private String itemDescription;
	@Column
	private Integer itemStockNumber;
	@Column
	private String itemRemarks;
	@Column
	private byte[] image;
	
	public ItemInventory() {
		// TODO Auto-generated constructor stub
	}

	public ItemInventory( Seller sellerId,ProductCategory category, ProductSubCategory subcategory, Double itemCost,
			String itemName, String itemDescription, Integer itemStockNumber, String itemRemarks,byte[] image) {
		
		this.sellerId = sellerId;
		this.category = category;
		this.subcategory = subcategory;
		this.itemCost = itemCost;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemStockNumber = itemStockNumber;
		this.itemRemarks = itemRemarks;
		this.image = image;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public void setSellerId(Seller sellerId) {
		this.sellerId = sellerId;
	}
	public Seller getSellerId() {
		return sellerId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public ProductSubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(ProductSubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getItemStockNumber() {
		return itemStockNumber;
	}

	public void setItemStockNumber(Integer itemStockNumber) {
		this.itemStockNumber = itemStockNumber;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}
	
	
	
	
	

}
