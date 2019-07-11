package com.sale.flashsale.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sale.flashsale.model.Buyer;
import com.sale.flashsale.model.FlashSale;
import com.sale.flashsale.model.Registration;

public interface RegistrationRepository{
	
	
	public Integer findBuyerRegistered(Integer flashsaleId, Integer buyerId);
	
	public Integer registerBuyer(Integer flashsaleId, Integer buyerId);
	
}
