package com.javasampleapproach.springintegration.inbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages= {"com.exception","com.springIntegration"})
@ImportResource({"classpath:http-inbound-gateway.xml"})
public class SpringIntegrationInboundComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationInboundComponentApplication.class, args);
	}
}
