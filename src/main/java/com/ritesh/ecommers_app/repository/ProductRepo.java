package com.ritesh.ecommers_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ritesh.ecommers_app.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query("""
    SELECT p FROM Product p
    WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))
        """)
    List<Product> searchProducts(@org.springframework.data.repository.query.Param("keyword") String keyword);
}
