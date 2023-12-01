package net.javaguides.orderservice.dto;

public class OrderEvent {
	
	private String status;
	private String message;
	private Order order;
	public OrderEvent(String status, String message, Order order) {
		super();
		this.status = status;
		this.message = message;
		this.order = order;
	}
	public OrderEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderEvent [status=" + status + ", message=" + message + ", order=" + order + "]";
	}
	
}
