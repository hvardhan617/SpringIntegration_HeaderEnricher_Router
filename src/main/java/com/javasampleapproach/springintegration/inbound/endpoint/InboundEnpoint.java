package com.javasampleapproach.springintegration.inbound.endpoint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.javasampleapproach.springintegration.inbound.model.Customer;
import com.javasampleapproach.springintegration.inbound.model.Test;
import com.javasampleapproach.springintegration.inbound.services.CustomerService;

@Component
public class InboundEnpoint {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource
	CustomerService custService;
	
	/*@Autowired
	private RestTemplate restTemplate;*/

	public Message<?> get(Message<?> msg) {
		log.info("GET method");
		List<Customer> custLst = custService.getAll();
		return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();
	}
	
	public Message<Customer> get2(Message<Customer> msg) {
		log.info("GET2 method");
		List<Test> test = new ArrayList<>();
		test.add(new Test());
		test.add(new Test());
		Test t=new Test();
		return MessageBuilder.withPayload(new Customer(1,"Harsha",23,t,test))/*.copyHeadersIfAbsent(msg.getHeaders())*/
				.setHeader("http_statusCode", HttpStatus.OK).build();
		//return new Customer(1,"Harsha",23,t);
	}
	
	public Message<Customer> beanValidator(Message<Customer> msg) {
		log.info("Bean Validator method");
		List<Test> test = new ArrayList<>();
		test.add(new Test());
		test.add(new Test());
		Test t=new Test();
		System.out.println(msg.getPayload().getAge());
		System.out.println(msg.getHeaders());
		/*Customer2 cust2 =new Customer2();
		cust2.setAge(msg.getPayload().getAge());
		cust2.setName(msg.getPayload().getName());
		cust2.setId(msg.getPayload().getId());*/
		/*BeanValidator beanValidator=restTemplate.postForObject("http://localhost:8999/validateBean",msg.getPayload(), BeanValidator.class);
		if(null != beanValidator.getExceptionMessage()) {
			throw new BeanValidationException(beanValidator.getExceptionMessage());
		}*/
		return MessageBuilder.withPayload(new Customer()).copyHeadersIfAbsent(msg.getHeaders()).setHeader("http_statusCode", HttpStatus.OK).build();
		
	}
	
	@Transformer
	public Message<Customer> transformer(Message<Customer> msg){
		System.out.println("Inside Transformer");
		return MessageBuilder.withPayload(new Customer()).copyHeadersIfAbsent(msg.getHeaders()).setHeader("http_statusCode", HttpStatus.OK).setHeader("produces", "application/xml").build();
		
	}
	
	
	public Customer/*Message<Customer>*/ post2(Message<Customer> msg) {
		log.info("POST 2 method");
		/*if(false) {
			throw new InvalidOrderException("Invalid Order Exception thrown");
		}*//*else {
			return MessageBuilder.withPayload(new Customer(1,"Harsha",23)).copyHeadersIfAbsent(msg.getHeaders())
					.setHeader("http_statusCode", HttpStatus.OK).build();
		}*/
		/*return MessageBuilder.withPayload(new Customer(1,"Harsha",23)).copyHeadersIfAbsent(msg.getHeaders())
				.setHeader("http_statusCode", HttpStatus.OK).build();
		*/
		return /*new ResponseEntity<Customer>(*/new Customer()/*,HttpStatus.OK)*/;
	}
	
	public void post(Message<Customer> msg){
		log.info("POST method");
		custService.insert(msg.getPayload());
	}
	
	public void put(Message<Customer> msg){
		log.info("PUT method");
		custService.change(msg.getPayload());
	}
	
	public void delete(Message<String>msg){
		log.info("DELETE method");
		int id = Integer.valueOf(msg.getPayload());
		custService.delete(id);
	}
	
	public void delete2(Message<LinkedList<String>> msg){
		log.info("DELETE2 method");
		LinkedList<String> id = msg.getPayload();
		
		System.out.println(msg + "::::::::"+id);
		System.out.println(msg.getPayload().toString());
		//custService.delete(id);
	}
}
