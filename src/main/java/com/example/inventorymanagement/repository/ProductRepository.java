package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    //sadece aktif olan ürünleri getir
    List<Product> findByIsActiveTrue();
    
    //stok miktarı belirli bir sayının altında olanları getir
    List<Product> findByStockQuantityLessThan(Integer quantity);
}