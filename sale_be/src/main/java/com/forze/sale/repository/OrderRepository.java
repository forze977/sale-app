package com.forze.sale.repository;

import java.util.List;

import com.forze.sale.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    OrderModel findByGuidAndTableNumber(String guid, int tableNumber);
    List<OrderModel> findAllByIsDoneOrderByTimestampAsc(boolean isDone);
}