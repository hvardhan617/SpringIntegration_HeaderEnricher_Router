package com.exception.customexception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Component;

import com.javasampleapproach.springintegration.inbound.model.Customer;
import com.javasampleapproach.springintegration.inbound.model.Test;

@Component
public class ErrorHandler {

	@ServiceActivator
	public Message<Customer> handleInvalidOrder(Message<MessageHandlingException> message) {
		System.out.println("Handling Error:::::::::::");
		System.out.println(message.getPayload().getLocalizedMessage());
		Test t =new Test();
		List<Test> list=new ArrayList<>();
		return MessageBuilder.withPayload(new Customer(1,message.getPayload().getLocalizedMessage(),23,t,list)).build();
		
	}
	
	@ServiceActivator
	public Message<Customer> handleBeanValidationError(Message<MessageHandlingException> message) {
		System.out.println("Handling handleBeanValidationError:::::::::::");
		System.out.println(message.getPayload().getLocalizedMessage());
		Test t =new Test();
		List<Test> list=new ArrayList<>();
		return MessageBuilder.withPayload(new Customer(1,message.getPayload().getLocalizedMessage(),23,t,list)).build();
		
	}
	
	@ServiceActivator
	public Message<Customer> handleGenericErrors(Message<MessageHandlingException> message) {
		System.out.println("Handling handleGenericErrors:::::::::::");
		System.out.println(message.getPayload().getLocalizedMessage());
		Test t =new Test();
		List<Test> list=new ArrayList<>();
		return MessageBuilder.withPayload(new Customer(1,message.getPayload().getLocalizedMessage(),23,t,list)).build();
		
	}
}
