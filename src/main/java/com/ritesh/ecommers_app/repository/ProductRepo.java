package com.ritesh.ecommers_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritesh.ecommers_app.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    
}
