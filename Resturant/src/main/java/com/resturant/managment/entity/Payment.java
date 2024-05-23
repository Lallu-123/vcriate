package com.resturant.managment.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Table(name = "PAYMENT")
@Entity
public class Payment implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "TOTAL_PRICE", nullable = false)
    private Double totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
