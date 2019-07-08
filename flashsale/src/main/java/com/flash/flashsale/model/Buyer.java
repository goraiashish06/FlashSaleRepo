package com.flash.flashsale.model;

import javax.persistence.*;
@Entity
@Table(name = "buyers")

public class Buyer {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;
}
