package com.ecommerce.seller.responsemodel;

public class SearchItemResponse {
	private Integer itemId;
	private Integer sellerId;
	private String itemName;
	private Integer stock;
	private Double price;
	private Integer categoryId;
	private String categoryName;
	private Integer subCategoryId;
	private String subCategoryName;
	private byte[] image;
	
	public SearchItemResponse() {
		
	}
	
	
	public SearchItemResponse(Integer itemId, Integer sellerId, String itemName, Integer stock, Double price,
			Integer categoryId, String categoryName, Integer subCategoryId, String subCategoryName, byte[] image) {
		
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.itemName = itemName;
		this.stock = stock;
		this.price = price;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.image = image;
	}


	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	
	
}
