package net.javaguides.orderservice.dto;

import java.util.Objects;

public class Order {
	
	private String orderId;
	private String name;
	private int quantity;
	private double price;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, String name, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, orderId, price, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(name, other.name) && Objects.equals(orderId, other.orderId)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
