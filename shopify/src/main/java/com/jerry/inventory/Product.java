package com.jerry.inventory;

import com.jerry.exception.ProductNotAvailableException;

public class Product {
	
	private String title;
	private Double price;
	private Integer inventoryCount;
	
	public Product(String title, Double price, Integer inventoryCount) {
		this.title = title;
		this.price = price;
		this.inventoryCount = inventoryCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	
	public void purchase() throws ProductNotAvailableException {
		if (inventoryCount <= 0) {
			throw new ProductNotAvailableException("There is no " + title + " avaiable!");
		}
		inventoryCount--;
	}
	
	public Boolean available() {
		return inventoryCount > 0;
	}

}
