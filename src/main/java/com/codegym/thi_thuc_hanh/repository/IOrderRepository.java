package com.codegym.thi_thuc_hanh.repository;

import com.codegym.thi_thuc_hanh.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {

}
