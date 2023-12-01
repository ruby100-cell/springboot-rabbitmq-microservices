package net.javaguides.emailservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import net.javaguides.emailservice.dto.OrderEvent;

@Service
public class OrderConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@RabbitListener(queues = "${rabbitmq.queue.email.name}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Order event received in email service => %s", event.toString()));
		
		//email service needs to send an email to customer
	}

}
