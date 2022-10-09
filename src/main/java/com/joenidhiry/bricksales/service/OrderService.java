package com.joenidhiry.bricksales.service;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderByRef(int id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getOrderReference());
    }
}
