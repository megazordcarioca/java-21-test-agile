package com.agileengine.testcode.main.repository;
import com.agileengine.testcode.main.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}