package net.javaguides.orderservice.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.order.name}")
	private String orderQueue;
	
	@Value("${rabbitmq.queue.email.name}")
	private String emailQueue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.binding.routing.key}")
	private String orderRoutingKey;
	
	@Value("${rabbitmq.binding.email.routing.key}")
	private String emailRoutingKey;
	
	//spring bean for queue - order queue
	@Bean
	public Queue orderQueue() {
		return new Queue(orderQueue);
	}
	
	@Bean
	public Queue emailQueue() {
		return new Queue(emailQueue);
	}
	
	//spring bean for exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	//spring bean for binding between exchange and queue using routing key-Order queue
	@Bean
	public Binding binding() {	
		return BindingBuilder.bind(orderQueue())
				.to(exchange())
				.with(orderRoutingKey);
	}
	
	//spring bean for binding between exchange and queue using routing key -emailQueue
		@Bean
		public Binding emailBinding() {	
			return BindingBuilder.bind(emailQueue())
					.to(exchange())
					.with(emailRoutingKey);
		}
		
	//message converter
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	//configure rabbit template
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	

}
