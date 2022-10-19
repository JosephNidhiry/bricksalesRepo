package com.joenidhiry.bricksales.service;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        List<Order> lorders = new ArrayList<>();
        orderRepository.findAll()
                .forEach(lorders::add);
        return lorders;
    }

    public Optional<Order> getOrderByRef(int id) {
        return orderRepository.findById(id);
    }

    public String setQuantityOrdered(int orderReference, BigDecimal quantityOrdered) {
        String message;
        Optional<Order> optionalOrder = orderRepository.findById(orderReference);
        if (optionalOrder.isPresent()) {
            Order originalOrder = optionalOrder.get();
            if (!originalOrder.getOrderDispatched()) {
                originalOrder.setQuantityOrdered(quantityOrdered);
                orderRepository.save(originalOrder);
                message = "New Quantity saved since order is yet to be dispatched";
            } else {
                message = "404 : Sorry the quantity cannot be amended since Order has been dispatched. Please create a New Order if required";
            }
        }
        else{
            message = "404 : Sorry the order reference does not exist. Please create a New Order for the Bricks";
        }
        return message;
        }

   public String updateOrderDispatchDate(int orderReference, LocalDate dispatchDate) {
        String message;
        Optional<Order> optionalOrder = orderRepository.findById(orderReference);
        if (optionalOrder.isPresent()) {
            Order originalOrder = optionalOrder.get();
            originalOrder.setOrderFulfilled(true);
            originalOrder.setDispatchDate(dispatchDate);
            message = "Dispatch Data for " + orderReference + " successfully updated to " + dispatchDate;
        } else {
            message = "404 : Non existent order " + orderReference;
        }
        return message;

    }
}

