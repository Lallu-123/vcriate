package com.resturant.managment.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resturant.management.constant.StatusConstant;
import com.resturant.managment.entity.OrderedItem;

@Repository
public interface OrderedItemsRepository extends CrudRepository<OrderedItem, Integer> {
    
    @Query("SELECT SUM(oi.price) from OrderedItem oi WHERE oi.order.requestedDate = ?1 AND oi.order.status = ?2")
    public Long totalPendingAmount(Date date, StatusConstant status);
    

}
