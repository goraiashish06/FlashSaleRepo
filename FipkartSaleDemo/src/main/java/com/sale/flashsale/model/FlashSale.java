package com.sale.flashsale.model;

import javax.persistence.*;
//import org.hibernate.annotations.Entity;
@Entity
@Table(name = "flashsales")
public class FlashSale {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "registration_open")
    private Boolean registrationOpen;
	public FlashSale(Integer id, Product product, Boolean status, Boolean registrationOpen) {
		super();
		this.id = id;
		this.product = product;
		this.status = status;
		this.registrationOpen = registrationOpen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getRegistrationOpen() {
		return registrationOpen;
	}

	public void setRegistrationOpen(Boolean registrationOpen) {
		this.registrationOpen = registrationOpen;
	}

	
}
