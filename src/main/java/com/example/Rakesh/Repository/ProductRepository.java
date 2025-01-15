package com.example.Rakesh.Repository;

import com.example.Rakesh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}