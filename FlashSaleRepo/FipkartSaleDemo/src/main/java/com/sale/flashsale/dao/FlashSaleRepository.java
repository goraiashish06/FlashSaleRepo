package com.sale.flashsale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sale.flashsale.model.Buyer;
//import com.sal.flashsale.model.Customer;
import com.sale.flashsale.model.FlashSale;

	@Repository
	public interface FlashSaleRepository extends JpaRepository<FlashSale, Integer>{	 
	
}
