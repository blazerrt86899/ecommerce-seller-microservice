package com.ecommerce.seller.model;

public class AuthToken {

    private String token;
    private String username;
    private Integer sellerId;

    public AuthToken(){

    }

    public AuthToken(String token, String username, Integer sellerId){
        this.token = token;
        this.username = username;
        this.sellerId = sellerId;
    }

    public Integer getSellerId() {
		return sellerId;
	}
    
    public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
    
    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
