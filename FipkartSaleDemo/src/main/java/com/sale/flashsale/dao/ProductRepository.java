package com.sale.flashsale.dao;

import com.sale.flashsale.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
