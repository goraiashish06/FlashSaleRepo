package com.sale.flashsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sale.flashsale.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
