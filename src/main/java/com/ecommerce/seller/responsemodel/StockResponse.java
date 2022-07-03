package com.ecommerce.seller.responsemodel;

public class StockResponse {

	private Integer itemId;
	private Integer itemQuantity;
	
	public StockResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public StockResponse(Integer itemId, Integer itemQuantity) {
		super();
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
	}
	
	
}
