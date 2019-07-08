package com.flash.flashsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flash.flashsale.model.Customer;
//import com.flash.flashsale.RegistrationService;
//import com.flash.flashsale.model.Customer;
import com.flash.flashsale.service.FlashSaleService;
import com.flash.flashsale.service.FlashSaleServiceImpl;

@RestController
public class FlashSaleController {
	
	@Autowired
	FlashSaleServiceImpl service;
	
	@RequestMapping(value= "/employee/", method= RequestMethod.GET)
    public String getCustomer() {
        System.out.println(this.getClass().getSimpleName() + " - Register new cust method is invoked.");
        return "Hello welcome to my service";
    } 
	
	@RequestMapping(value= "/", method= RequestMethod.GET)
    public String getCustomer1() {
        System.out.println(this.getClass().getSimpleName() + " - Register new cust method is invoked.");
        return "Hello welcome to my service";
    } 
	
	@RequestMapping(value= "/employee/add", method= RequestMethod.POST)
    public Customer registerCustomer(@RequestBody Customer newcust) {
        System.out.println(this.getClass().getSimpleName() + " - Register new cust method is invoked.");
        return service.registerCustomer(newcust);
    }

}
