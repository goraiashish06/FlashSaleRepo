package com.sale.flashsale.model;

import javax.persistence.*;
//import org.hibernate.annotations.Entity;
@Entity
@Table(name = "buyers")

public class Buyer {
	public Buyer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;
}
