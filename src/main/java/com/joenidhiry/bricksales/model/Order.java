package com.joenidhiry.bricksales.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Order {
    @Id
    private Integer orderReference;
    private String customerName;
    private BigDecimal quantityOrdered;
    private Boolean orderFulfilled;

    public Order(String customerName, BigDecimal quantityOrdered) {
        this.customerName = customerName;
        this.quantityOrdered = quantityOrdered;
        this.orderFulfilled = false;
    }

    public Integer getOrderReference() {
        return orderReference;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getQuantityOrdered() {
        return quantityOrdered;
    }

    public Boolean getOrderDispatched() {
        return orderFulfilled;
    }
}
