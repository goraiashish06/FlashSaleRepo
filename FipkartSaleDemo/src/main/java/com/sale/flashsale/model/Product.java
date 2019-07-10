package com.sale.flashsale.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "sku")
    private Integer sku;
}
