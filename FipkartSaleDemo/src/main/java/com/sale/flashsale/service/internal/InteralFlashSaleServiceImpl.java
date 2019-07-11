package com.sale.flashsale.service.internal;

import org.springframework.beans.factory.annotation.Autowired;

import com.sale.flashsale.dao.FlashSaleRepository;
import com.sale.flashsale.model.FlashSale;
import com.sale.flashsale.model.Product;

public class InteralFlashSaleServiceImpl implements InternalFlashSaleService{
	
	@Autowired
	FlashSaleRepository flashSaleRepository;
	
	@Override
    public FlashSale createFlashSale(final Product p) {
        FlashSale f = new FlashSale();
        f.setProduct(p);
        f.setStatus(Boolean.FALSE);
        f.setRegistrationOpen(Boolean.TRUE);
       
        return flashSaleRepository.save(f);
    }

	@Override
	public Boolean startFlashSale(FlashSale f) {
		    //preprocess(f);
	        f.setStatus(Boolean.TRUE);
	        f.setRegistrationOpen(Boolean.FALSE);
	        flashSaleRepository.saveAndFlush(f);
	        
	        return true;	}

	@Override
	public Boolean stopFlashSale(FlashSale f) {
		f.setStatus(Boolean.FALSE);
        flashSaleRepository.saveAndFlush(f);
        
        return true;	}
}
