package com.sale.flashsale.model;

import com.sale.flashsale.model.OrderStatus;


import javax.persistence.*;
import java.util.Date;
	
	@Entity
	@Table(name = "orders")
	
	public class Order {

	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name = "id", columnDefinition = "serial")
	    private Integer id;

	    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id")
	    private Product product;

	    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	    @JoinColumn(name = "buyer_id")
	    private Buyer buyer;

	    @Column(name = "created_at", columnDefinition = "timestamp without time zone")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdAt;

	    @Column(name = "updated_at", columnDefinition = "timestamp without time zone")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date updatedAt;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "order_status")
	    private OrderStatus orderStatus;

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

		public Buyer getBuyer() {
			return buyer;
		}

		public void setBuyer(Buyer buyer) {
			this.buyer = buyer;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public OrderStatus getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
		}


}
