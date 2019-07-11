package com.sale.flashsale.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

//	import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sale.flashsale.model.Buyer;
import com.sale.flashsale.model.FlashSale;
import com.sale.flashsale.model.Registration;
import com.sale.flashsale.model.RegistrationResult;

@Repository
public class RegistrationRepoImpl implements RegistrationRepository{
	@PersistenceContext
    private EntityManager em;
	

	@Override
	public Integer findBuyerRegistered(Integer flashsaleId, Integer buyerId) {
		  
	      Query q=em.createQuery("SELECT id FROM registrations r WHERE r.flashsale_id= :flashsaleId AND r.buyer_id=:buyerId").setParameter("flashsaleId", flashsaleId).setParameter("buyerId", buyerId);
	      q.executeUpdate();
	      List<Integer> rl = q.getResultList();
	      em.close();
	      return rl.get(1);
	}
	@Override
	public Integer registerBuyer(Integer flashsaleId, Integer buyerId) {
		 Query q=em.createQuery("INSERT INTO registrations (flashsale_id, buyerid) VALUES (?,?)").setParameter(1, flashsaleId).setParameter(2, buyerId);
	     try {
		 int update=q.executeUpdate();
		 if(update>0)
		       return 1;
		      else
		    	return 0;
	     }
	     catch(TransactionRequiredException ex) {
	    	 return 0;
	     }
	     finally {
	    	 em.close();
	     }
	     
	     
	}
	
}
