package com.ritesh.ecommers_app.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

import com.ritesh.ecommers_app.repository.ProductRepo;
import com.ritesh.ecommers_app.model.Product;


@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

}
