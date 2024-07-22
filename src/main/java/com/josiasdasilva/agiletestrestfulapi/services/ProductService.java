package com.josiasdasilva.agiletestrestfulapi.services;


import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import org.springframework.stereotype.Service;


@Service
public interface ProductService extends CrudService<Product, Long> {

}
