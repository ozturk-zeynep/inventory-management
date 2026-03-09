package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Product;
import com.example.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") 
public class ProductController {

    @Autowired
    private ProductService productService;

    //tüm aktif ürünleri listeler (get)
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllActiveProducts();
    }

    //yeni ürün ekler (post)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //ürünü pasif yapma (delete)
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Ürün başarıyla silindi (pasif yapıldı).";
    }
}