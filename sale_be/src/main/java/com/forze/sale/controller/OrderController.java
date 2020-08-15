package com.forze.sale.controller;

import java.util.ArrayList;
import java.util.List;

import com.forze.sale.model.OrderModel;
import com.forze.sale.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/order/")
@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("getall")
    public List<String> getAllQueue(){
        List<OrderModel> orders = orderRepository.findAllByIsDoneOrderByTimestampAsc(false);
        List<String> queue = new ArrayList<String>();
        orders.forEach(order -> queue.add(order.getGuid()));
        return queue;
    }

    @PostMapping("save")
    public void saveQueue(@RequestBody OrderModel order){
        orderRepository.save(order);
    }

    @PostMapping("update")
    public void updateOrder(@RequestBody OrderModel queue){
        OrderModel order = orderRepository.findByGuidAndTableNumber(queue.getGuid(), queue.getTableNumber());
        order.setOrderString(queue.getOrderString());
        orderRepository.save(order);
    }

    @PostMapping("cancel")
    public void cancelOrder(@RequestBody OrderModel order){
        order = orderRepository.findByGuidAndTableNumber(order.getGuid(), order.getTableNumber());
        order.setDone(true);
        order.setCancel(true);
        orderRepository.save(order);
    }

    @PostMapping("clear")
    public void clearQueue(@RequestBody OrderModel queue){
        OrderModel order = orderRepository.findByGuidAndTableNumber(queue.getGuid(), queue.getTableNumber());
        order.setDone(true);
        orderRepository.save(order);
    }
}