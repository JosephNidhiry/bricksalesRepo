package com.joenidhiry.bricksales.repository;

import com.joenidhiry.bricksales.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
