package com.joenidhiry.bricksales;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.repository.OrderRepository;
import com.joenidhiry.bricksales.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses= Order.class)
@SpringBootApplication
public class BricksalesApplication {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(BricksalesApplication.class, args);
	}

}
