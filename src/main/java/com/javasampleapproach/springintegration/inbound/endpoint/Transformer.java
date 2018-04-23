package com.javasampleapproach.springintegration.inbound.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.javasampleapproach.springintegration.inbound.model.Customer;

@Component
public class Transformer {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	
	@org.springframework.integration.annotation.Transformer
	public Message<Customer> transformMessage(Message<?> msg){
		log.info("Inside Transformer with payload:::::"+msg.getPayload());
		return MessageBuilder.withPayload(new Customer(23,null,23)).copyHeadersIfAbsent(msg.getHeaders()).setHeader("http_statusCode", HttpStatus.OK).build();
		
	}

}
