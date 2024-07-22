package com.josiasdasilva.agiletestrestfulapi.controllers;

import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import com.josiasdasilva.agiletestrestfulapi.services.CrudService;
import com.josiasdasilva.agiletestrestfulapi.services.ProductService;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController extends CrudController <Product,Long> {
    @Autowired
    private ProductService productService;

    @Override
    public CrudService<Product, Long> getService() {
        return productService;
    }

}
