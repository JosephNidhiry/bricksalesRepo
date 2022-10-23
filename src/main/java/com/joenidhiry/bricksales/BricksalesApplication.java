package com.joenidhiry.bricksales;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.repository.OrderRepository;
import com.joenidhiry.bricksales.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
@EnableJpaRepositories
public class BricksalesApplication {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(BricksalesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			orderService.createOrder(new Order("Joe", BigDecimal.valueOf(20)));
		};
	}
}


