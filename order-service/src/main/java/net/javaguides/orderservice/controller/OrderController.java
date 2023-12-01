package net.javaguides.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.orderservice.dto.Order;
import net.javaguides.orderservice.dto.OrderEvent;
import net.javaguides.orderservice.publisher.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order ) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("Order is in pending status");
		orderEvent.setOrder(order);
		
		orderProducer.sendMessage(orderEvent);
		return "Order sent to the RabbitMQ ..";
		
	}
	

}
