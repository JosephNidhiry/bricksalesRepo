package com.joenidhiry.bricksales.controller;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BrickOrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submitBrickOrder")
    public Order addOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/BrickOrder/{id}")
    public Order getOrderByReference(@PathVariable int orderReference) {
        Optional<Order> optionalOrderByRef   = orderService.getOrderByRef(orderReference);
        return optionalOrderByRef.get();
    }

    @GetMapping("/brickOrders")
    public List<Order> retrieveAllOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/DispatchBrickOrder/{orderReference}/{dispatchDate}")
    public Order dispatchOrder(@PathVariable int orderReference, @PathVariable String dispatchDate) {
        Optional<Order> optionalOrderByRef = orderService.getOrderByRef(orderReference);
        String message1;
        if (optionalOrderByRef.isPresent()) {
    /*        return optionalOrderByRef.get().setDispatchDate(orderReference, dispatchDate); */
              return optionalOrderByRef.get();
        } else {
            return null;
        }

    }

}
