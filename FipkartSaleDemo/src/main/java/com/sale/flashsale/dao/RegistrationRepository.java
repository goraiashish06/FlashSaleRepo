package com.sale.flashsale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sale.flashsale.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

//	List<Registration> findByFlashSaleIdAndBuyerId();
//
//	List<Registration> findByFlashSaleId();
//
//	Registration findByFlashSaleIdInAndBuyerIdIn(Integer id, Integer id2);

	
	
}
