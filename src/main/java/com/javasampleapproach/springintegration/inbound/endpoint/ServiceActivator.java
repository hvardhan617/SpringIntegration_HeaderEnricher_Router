package com.javasampleapproach.springintegration.inbound.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.exception.customexception.BeanValidationException;
import com.javasampleapproach.springintegration.inbound.model.BeanValidator;
import com.javasampleapproach.springintegration.inbound.model.Customer;
import com.javasampleapproach.springintegration.inbound.model.Test;

@Component
public class ServiceActivator {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	ValidatorFactory hibernateVF = Validation.byProvider(HibernateValidator.class)
			.configure().buildValidatorFactory();
	Validator validator = hibernateVF.getValidator();

	@org.springframework.integration.annotation.ServiceActivator
	public Message<Customer> beanValidator(Message<Customer> msg) {
		log.info("Inside Service Activator with payload::::::" + msg.getPayload());
		List<Test> test = new ArrayList<>();
		test.add(new Test());
		test.add(new Test());
		Test t = new Test();
		System.out.println(msg.getPayload().getAge());
		System.out.println(msg.getHeaders());
		BeanValidator beanValidator = new BeanValidator();
		beanValidator.setObject(msg.getPayload());
		beanValidator=beanValidator2(beanValidator);
		return MessageBuilder.withPayload(new Customer(23, "Harsha", 23, t, test)).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();

	}

	public BeanValidator beanValidator2(BeanValidator obj) {
		System.out.println("\nValidation in composition using @Valid annotation");
		// @Valid annotation - validation in composition example
		Set<ConstraintViolation<BeanValidator>> validationCompositionErrors = validator.validate(obj);

		if (!validationCompositionErrors.isEmpty()) {
			for (ConstraintViolation<BeanValidator> error : validationCompositionErrors) {
				System.out.println(
						error.getMessageTemplate() + "::" + error.getPropertyPath() + "::" + error.getMessage());

			}
			System.out.println("Bean validation failed with errors");
			throw new BeanValidationException("Hibernate Bean Validation Failed");
		}
		
		return obj;

	}
}
