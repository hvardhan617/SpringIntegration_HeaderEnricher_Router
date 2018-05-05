package com.springIntegration.dynamic.serviceAct;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.springIntegration.dynamic.models.BeanValidator;
import com.springIntegration.dynamic.models.Customer;
import com.springIntegration.dynamic.models.Test;
import com.springIntegration.utils.BeanValidationUtil;

@Component
public class ServiceActivators {
	
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private BeanValidationUtil beanValidationUtil;
	
	@Autowired
	public ServiceActivators(BeanValidationUtil beanValidationUtil){
		this.beanValidationUtil=beanValidationUtil;
	}
	
	
	@org.springframework.integration.annotation.ServiceActivator
	public Message<?> axisServiceActivator(Message<?> msg) {
		log.info("Inside Axis Service Activator with payload::::::" + msg.getPayload());
		List<Test> test = new ArrayList<>();
		test.add(new Test());
		test.add(new Test());
		Test t = new Test();
		System.out.println(msg.getHeaders());
		BeanValidator beanValidator = new BeanValidator();
		beanValidator.setObject(msg.getPayload());
		beanValidator=beanValidationUtil.validateInputBeans(beanValidator);
		return MessageBuilder.withPayload(new Customer(23, "AXIS", 23, t, test)).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();

	}
	
	@org.springframework.integration.annotation.ServiceActivator
	public Message<?> upiServiceActivator(Message<?> msg) {
		log.info("Inside UPI Service Activator with payload::::::" + msg.getPayload());
		List<Test> test = new ArrayList<>();
		test.add(new Test());
		test.add(new Test());
		Test t = new Test();
		System.out.println(msg.getHeaders());
		BeanValidator beanValidator = new BeanValidator();
		beanValidator.setObject(msg.getPayload());
		beanValidator=beanValidationUtil.validateInputBeans(beanValidator);
		return MessageBuilder.withPayload(new Customer(23, "UPI", 23, t, test)).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();

	}

}
