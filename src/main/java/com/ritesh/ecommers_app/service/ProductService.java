package com.ritesh.ecommers_app.service;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

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
    public Product addProduct(Product product,MultipartFile imageFile) throws IOException{
        System.out.println(product);
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }
    public Product updateProduct(Integer id,Product product,MultipartFile imageFile) throws IOException{
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }
    public void deleteProduct(Integer id){
        repo.deleteById(id);
    }
    public List<Product> searchProducts(String keyword){
        // System.out.println(keyword);
        return repo.searchProducts(keyword);
    }
    

}
