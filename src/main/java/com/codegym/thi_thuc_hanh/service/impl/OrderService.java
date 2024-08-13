package com.codegym.thi_thuc_hanh.service.impl;


import com.codegym.thi_thuc_hanh.model.Orders;
import com.codegym.thi_thuc_hanh.repository.IOrderRepository;
import com.codegym.thi_thuc_hanh.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Optional<Orders> findOrderById(Integer orderId) {
        return orderRepository.findById(Long.valueOf(orderId));
    }

    @Override
    public void updateOrder(Orders orders) {
        orderRepository.save(orders);
    }
}
