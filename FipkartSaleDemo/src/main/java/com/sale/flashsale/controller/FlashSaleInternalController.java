package com.sale.flashsale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sale.flashsale.model.FlashSale;
import com.sale.flashsale.model.Product;
import com.sale.flashsale.model.PurchaseResult;
import com.sale.flashsale.model.RegistrationResult;
import com.sale.flashsale.service.FlashSaleServiceImpl;
import com.sale.flashsale.service.internal.InternalFlashSaleService;

public class FlashSaleInternalController {

	@Autowired
	InternalFlashSaleService service;
	
	
	@RequestMapping(value= "/createflashsale", method= RequestMethod.POST)
    public FlashSale registerCustomer(@RequestBody Product p) {
            
        
        return service.createFlashSale(p);
    }
	@RequestMapping(value= "/stopflashsale/", method= RequestMethod.POST)
    public Boolean stopFlashSale(@RequestBody FlashSale f) {
        return service.stopFlashSale(f);
    } 
	@RequestMapping(value= "/startflashsale/", method= RequestMethod.POST)
    public Boolean startFlashSale(@RequestBody FlashSale f) {        
        
        return service.startFlashSale(f);
    } 
}
