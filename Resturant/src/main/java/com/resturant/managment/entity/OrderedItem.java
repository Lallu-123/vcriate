package com.resturant.managment.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Table(name = "ORDER_ITEM")
@Entity
public class OrderedItem implements Serializable {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ITEM_NAME", nullable = false)
    private String itemName;
    
    @Column(name = "PRICE", nullable = false)
    private Double price;
    
    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;
    
    @JoinColumn(name = "ORDERS", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
    
    
    
    
    
}
