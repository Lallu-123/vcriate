package com.resturant.management.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
	private Integer id;
    private String orderName;
    private String status;
    private List<OrderedItemDto> items;
    private Date orderedDate;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public List<OrderedItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderedItemDto> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }
}
