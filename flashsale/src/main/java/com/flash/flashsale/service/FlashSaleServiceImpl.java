package com.flash.flashsale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flash.flashsale.dao.BuyerRepository;
import com.flash.flashsale.dao.FlashSaleRepository;
import com.flash.flashsale.model.Buyer;
import com.flash.flashsale.model.Customer;
import com.flash.flashsale.model.FlashSale;
import com.flash.flashsale.model.Registration;
import com.flash.flashsale.pojo.PurchaseResult;
import com.flash.flashsale.pojo.RegistrationResult;

@Service
public class FlashSaleServiceImpl implements FlashSaleService{

	 @Autowired
	 FlashSaleRepository flashsaledao;

	 @Autowired
	 BuyerRepository buyerdao;
	/*
	 * @Override public List<Customer> getEmployees(){ return null; }
	 * 
	 * @Override public Customer registerCustomer(Customer emp) { return null; }
	 */
	@Override
	public RegistrationResult register(Integer flashsaleId, Integer buyerId) {
		FlashSale f = flashsaledao.findOne(flashsaleId);
        Buyer b = buyerdao.findOne(buyerId);
        RegistrationResult registrationResult = new RegistrationResult();
        registrationResult.setStatus(Boolean.FALSE);
        
        if (f == null || !f.getRegistrationOpen() || f.getStatus() == Boolean.TRUE) {
            registrationResult.setMessage("Invalid flashsale");
        } else if (b == null) {
            registrationResult.setMessage("Invalid buyer");
        } else {
            Registration registration = registrationClient.findRegistrationByFlashsaleBuyer(f, b);
            if (registration != null) {
                registrationResult.setMessage("Buyer already registered");
                registrationResult.setRegistrationId(registration.getId());
            } else {
                registrationResult = registrationClient.newRegistrationResult(b, f);
            }
        }
        return registrationResult;
	}
	@Override
	public Boolean isEligible(Integer flashsaleId, Integer buyerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PurchaseResult purchase(Integer flashsaleId, Integer buyerId) {
		// TODO Auto-generated method stub
		return null;
	}
	public Customer registerCustomer(Customer newcust) {
		// TODO Auto-generated method stub
		return null;
	}

}
