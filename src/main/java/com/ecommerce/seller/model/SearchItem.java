package com.ecommerce.seller.model;

public class SearchItem {
	
	private String searchString;
	//private String manufacturer;
	//private Double fromPrice;
	//private Double toPrice;
	
	public SearchItem() {
		// TODO Auto-generated constructor stub
	}

	public SearchItem(String searchString) {
		
		this.searchString = searchString;
	}
	
	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	
	
	

}
