package com.springIntegration.dynamic.transformers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.springIntegration.dynamic.models.Customer;

@Component
public class UpiTransformer {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@org.springframework.integration.annotation.Transformer
	public Message<Customer> transformUpiMessage(Message<?> msg) {
		log.info("Inside UPI Transformer with payload:::::" + msg);
		return MessageBuilder.withPayload(new Customer(23, "Harsha", 23)).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();

	}

}
