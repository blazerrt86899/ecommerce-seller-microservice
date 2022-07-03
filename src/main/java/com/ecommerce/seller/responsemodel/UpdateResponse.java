package com.ecommerce.seller.responsemodel;



public class UpdateResponse {
	
	private Double itemCost;
	private String itemName;
	private String itemDescription;
	private Integer itemStockNumber;
	private String itemRemarks;

	public UpdateResponse() {
		// TODO Auto-generated constructor stub
	}

	public UpdateResponse(Double itemCost, String itemName, String itemDescription, Integer itemStockNumber,
			String itemRemarks) {
		super();
		this.itemCost = itemCost;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemStockNumber = itemStockNumber;
		this.itemRemarks = itemRemarks;
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
