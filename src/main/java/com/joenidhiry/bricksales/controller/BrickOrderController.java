package com.joenidhiry.bricksales.controller;

import com.joenidhiry.bricksales.model.Order;
import com.joenidhiry.bricksales.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BrickOrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submitBrickOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/BrickOrder/{id}")
    public ResponseEntity<Order> getOrderByReference(@PathVariable int orderReference) {
        Optional<Order> optionalOrderByRef   = orderService.getOrderByRef(orderReference);
        return ResponseEntity.ok(optionalOrderByRef.get());
    }

    @GetMapping("/BrickOrders")
    public ResponseEntity<List<Order>> retrieveAllOrders() {

        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("/DispatchBrickOrder/{orderReference}/{dispatchDate}")
    public ResponseEntity<Order> dispatchOrder(@PathVariable int orderReference, @PathVariable String dispatchDate) {
        Optional<Order> optionalOrderByRef = orderService.getOrderByRef(orderReference);
        String message1;
        if (optionalOrderByRef.isPresent()) {
    /*        return optionalOrderByRef.get().setDispatchDate(orderReference, dispatchDate); */
              return ResponseEntity.ok(optionalOrderByRef.get());
        } else {
            return ResponseEntity.ok(null);
        }

    }

}
