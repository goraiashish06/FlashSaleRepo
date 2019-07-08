package com.flash.flashsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flash.flashsale.model.Customer;

public interface BuyerRepository extends JpaRepository<Customer, Integer>  {

}
