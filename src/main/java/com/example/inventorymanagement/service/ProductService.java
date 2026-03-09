package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //tüm aktif ürünleri getirir
    public List<Product> getAllActiveProducts() {
        return productRepository.findByIsActiveTrue();
    }

    //stok kontrolü yapar ve yeni ürün ekler
    public Product saveProduct(Product product) {
        
        if (product.getStockQuantity() < 0) {
            product.setStockQuantity(0);
        }
        return productRepository.save(product);
    }

    //ürünü pasif hale getirir
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setIsActive(false); //veriyi silmek yerine sadece görünmez yapar
            productRepository.save(product);
        }
    }
}