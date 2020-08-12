package com.forze.sale.repository;

import com.forze.sale.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    
}