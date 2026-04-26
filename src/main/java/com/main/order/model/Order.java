package com.main.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name ="orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private long quantity;
	private String foodItem;
	public long getOrderId()
	{
		return orderId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
}
