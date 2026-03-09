package com.example.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Products") // SQL'deki tablo adıyla birebir aynı olmalı
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "stock") // SQL'deki "stock" sütunuyla eşleşmesi için kritik satır!
    private Integer stockQuantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "is_active") // SQL'deki "is_active" sütunuyla eşleştiriyoruz
    private Boolean isActive = true;
}