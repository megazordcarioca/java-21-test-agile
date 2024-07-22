package com.josiasdasilva.agiletestrestfulapi.repositories;

import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
