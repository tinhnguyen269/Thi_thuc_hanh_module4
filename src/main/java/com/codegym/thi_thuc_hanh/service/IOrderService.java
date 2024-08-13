package com.codegym.thi_thuc_hanh.service;


import com.codegym.thi_thuc_hanh.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {

    Page<Orders> findAll(Pageable pageable);

    Optional<Orders> findOrderById(Integer orderId);

    void updateOrder(Orders orders);
}
