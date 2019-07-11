package com.sale.flashsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sale.flashsale.model.Buyer;
import com.sale.flashsale.model.PurchaseResult;
import com.sale.flashsale.model.RegistrationResult;
import com.sale.flashsale.service.FlashSaleServiceImpl;


@RestController
public class FlashSaleController {

	@Autowired
	FlashSaleServiceImpl service;
	
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
    public RegistrationResult registerCustomer(@RequestParam Integer buyerId,@RequestParam Integer flashSaleId) {
        System.out.println(this.getClass().getSimpleName() + " - Register new cust method is invoked.");        
        
        return service.register(buyerId, flashSaleId);
    }
	@RequestMapping(value= "/sale/", method= RequestMethod.POST)
    public PurchaseResult processSale(@RequestParam Integer buyerId,@RequestParam Integer flashSaleId, @RequestParam Integer productId) {
        System.out.println(this.getClass().getSimpleName() + " - Register new cust method is invoked.");
        PurchaseResult pr=service.purchase(flashSaleId, buyerId, productId);
        System.out.println("in controller::"+ service.register(101, 201));
        return pr;
    } 
}
