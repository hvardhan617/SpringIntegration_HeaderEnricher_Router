package com.javasampleapproach.springintegration.inbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages= {"com.exception","com.javasampleapproach"})
@ImportResource({/*"classpath:http-inbound-adapter.xml", "classpath:http-inbound-gateway.xml",*/"classpath:test.xml"})
public class SpringIntegrationInboundComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationInboundComponentApplication.class, args);
	}
}
