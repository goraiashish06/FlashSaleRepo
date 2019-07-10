package com.sale.flashsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sale.flashsale.model.Buyer;
//mport com.sale.flashsale.model.Customer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>  {

}
