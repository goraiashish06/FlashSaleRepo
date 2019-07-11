package com.sale.flashsale.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.flash.flashsale.FlashSaleRepository;
import com.sale.flashsale.dao.BuyerRepository;
import com.sale.flashsale.dao.FlashSaleRepository;
import com.sale.flashsale.dao.OrderRepository;
import com.sale.flashsale.dao.ProductRepository;
import com.sale.flashsale.dao.RegistrationRepoImpl;
import com.sale.flashsale.dao.RegistrationRepository;
import com.sale.flashsale.model.Buyer;
//import com.flash.flashsale.model.Customer;
import com.sale.flashsale.model.FlashSale;
import com.sale.flashsale.model.Order;
import com.sale.flashsale.model.OrderStatus;
import com.sale.flashsale.model.Product;
import com.sale.flashsale.model.Registration;
import com.sale.flashsale.model.PurchaseResult;
import com.sale.flashsale.model.RegistrationResult;

@Service
public class FlashSaleServiceImpl implements FlashSaleService{

	 @Autowired
	 com.sale.flashsale.dao.FlashSaleRepository flashsaledao;	 

	 @Autowired
	 BuyerRepository buyerdao;
	 @Autowired
	 RegistrationRepository regdao;
	 
	 @Autowired
	 FlashSaleRepository fashsaledao;
	 
	 @Autowired
	 ProductRepository productdao;
	 
	 @Autowired
	 OrderRepository orderdao;
	 
	 static int skuValue;
	/*
	 * @Override public List<Customer> getEmployees(){ return null; }
	 * 
	 * @Override public Customer registerCustomer(Customer emp) { return null; }
	 */
	@Override
	@Transactional(readOnly = true)
	public RegistrationResult register(final Integer flashsaleId, final Integer buyerId) {
		FlashSale f = flashsaledao.findById(flashsaleId).orElse(null);
		Buyer b = buyerdao.findById(buyerId).orElse(null);
        RegistrationResult registrationResult = new RegistrationResult();
        registrationResult.setStatus(Boolean.FALSE);
        
        
        
        if (f!=null) {
            registrationResult.setMessage("Invalid flashsale");
        } else if (b!=null) {
            registrationResult.setMessage("Invalid buyer");
        } else {
            Integer reg_Id = regdao.findBuyerRegistered(flashsaleId, buyerId);
        	//Registration registration=null;
            if (reg_Id != null) {
                registrationResult.setMessage("Buyer already registered");
                registrationResult.setRegistrationId(reg_Id);
            } else {
                int reg = regdao.registerBuyer(flashsaleId, buyerId);
                if(reg>0) {
                	registrationResult.setMessage("Success");
                	registrationResult.setStatus(Boolean.TRUE);
                }
            }
        }
        return registrationResult;
	}
	@Override
	public Boolean isEligible(Integer flashsaleId, Integer buyerId) {
		 Integer reg_Id = regdao.findBuyerRegistered(flashsaleId, buyerId);
		 
		 if (reg_Id != null) {
             return Boolean.TRUE;
         } else {
             return Boolean.FALSE;
             }
         
	}
	@Override
	@Transactional(readOnly = true)
	public PurchaseResult purchase(Integer flashsaleId, Integer buyerId, Integer productId) {
		PurchaseResult pr= new PurchaseResult();
		
		Boolean isValid=isEligible(flashsaleId,buyerId);
		//Order oo=new Order();
		if(isValid) {
			synchronized(this) {
			if(checkStock(productId)) {			
						
				

			        Order order = new Order();
			        order.setBuyer(buyerdao.findById(buyerId).orElse(null));
			        order.setProduct(productdao.findById(productId).orElse(null));
			        order.setCreatedAt(new Date());
			        order.setOrderStatus(OrderStatus.APPROVED);
			        orderdao.saveAndFlush(order);					
				}
			else {
				pr.setStatus(Boolean.FALSE);
				pr.setBuyerId(buyerId);
			}
				
				pr.setStatus(Boolean.TRUE);
				pr.setBuyerId(buyerId);
				
			}
			
		}
		else {
			pr.setStatus(Boolean.FALSE);
			pr.setBuyerId(buyerId);
			//pr.setProductId(productId);
		}
		
		return pr;
		
	}
   public Boolean checkStock(Integer productId) {
		Product pr=productdao.findById(productId).orElse(null);
		if(pr.getSku()>0 && pr.getSku()!=null) {
			return Boolean.TRUE;
		}
		else {
		return Boolean.FALSE;
		}
	}
	

}