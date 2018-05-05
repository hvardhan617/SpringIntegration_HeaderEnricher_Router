package com.springIntegration.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.springIntegration.dynamic.exceptions.BeanValidationException;
import com.springIntegration.dynamic.models.BeanValidator;

@Component
public class BeanValidationUtil {

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	ValidatorFactory hibernateVF = Validation.byProvider(HibernateValidator.class)
			.configure().buildValidatorFactory();
	Validator validator = hibernateVF.getValidator();

	public BeanValidator validateInputBeans(BeanValidator obj) {
		log.info("\nValidation in composition using @Valid annotation");
		// @Valid annotation - validation in composition example
		Set<ConstraintViolation<BeanValidator>> validationCompositionErrors = validator.validate(obj);

		if (!validationCompositionErrors.isEmpty()) {
			for (ConstraintViolation<BeanValidator> error : validationCompositionErrors) {
				System.out.println(
						error.getMessageTemplate() + "::" + error.getPropertyPath() + "::" + error.getMessage());

			}
			log.error("Bean validation failed with errors");
			throw new BeanValidationException("Hibernate Bean Validation Failed");
		}
		
		return obj;

	}
}
