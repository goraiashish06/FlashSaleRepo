package com.sale.flashsale.model;


import javax.persistence.*;
//import org.hibernate.annotations.Entity;

import com.sale.flashsale.model.RegistrationStatus;

@Entity
@Table(name = "registrations")
public class Registration {
	public Registration(Integer id, FlashSale flashSale, Buyer buyer, RegistrationStatus registrationStatus) {
		super();
		this.id = id;
//		this.flashSale = flashSale;
//		this.buyer = buyer;
		this.registrationStatus = registrationStatus;
	}

	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public FlashSale getFlashSale() {
//		return flashSale;
//	}
//
//	public void setFlashSale(FlashSale flashSale) {
//		this.flashSale = flashSale;
//	}
//
//	public Buyer getBuyer() {
//		return buyer;
//	}
//
//	public void setBuyer(Buyer buyer) {
//		this.buyer = buyer;
//	}

	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

//    @OneToOne()
//    @JoinColumn(name = "flashsale_id")
//    private FlashSale flashSale;
//
//    @OneToOne()
//    @JoinColumn(name = "buyer_id")
//    private Buyer buyer;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_status")
    private RegistrationStatus registrationStatus;
}
