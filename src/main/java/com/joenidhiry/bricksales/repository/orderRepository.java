package com.joenidhiry.bricksales.repository;

import com.joenidhiry.bricksales.model.Order;
import org.hibernate.cfg.annotations.reflection.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order,Integer> {
}
