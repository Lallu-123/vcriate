package com.resturant.managment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.resturant.management.constant.StatusConstant;

import jakarta.persistence.*;

@Table(name = "ORDERS")
@Entity
public class Orders implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ORDER_NAME", nullable = false)
    private String orderName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private StatusConstant status;
    
   
    @Column(name = "REQUESTED_DATE")
    private Date requestedDate;
    
    @JoinColumn(name = "USER_LOGIN", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserLogin orderRecievedBy;
    
    @JoinColumn(name = "PAYMENT")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderedItem> orderedItems;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public List<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public StatusConstant getStatus() {
        return status;
    }

    public void setStatus(StatusConstant status) {
        this.status = status;
    }

    public UserLogin getOrderRecievedBy() {
        return orderRecievedBy;
    }

    public void setOrderRecievedBy(UserLogin orderRecievedBy) {
        this.orderRecievedBy = orderRecievedBy;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    
}
