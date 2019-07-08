package com.flash.flashsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.flash.flashsale.model.Customer;

@Repository
	public interface FlashSaleRepository extends JpaRepository<Customer, Integer> {	 
	
}
