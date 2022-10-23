package com.joenidhiry.bricksales.model;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderReference;
    private String customerName;
    private BigDecimal quantityOrdered;
    @Nullable
    private Boolean orderFulfilled;
    @Nullable
    private LocalDate dispatchDate;

    public Order() {
    }

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

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setQuantityOrdered(BigDecimal quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setOrderFulfilled(Boolean orderFulfilled) {
        this.orderFulfilled = orderFulfilled;
    }


    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }
}
