package com.josiasdasilva.agiletestrestfulapi.controllers;

import com.josiasdasilva.agiletestrestfulapi.entities.Order;
import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import com.josiasdasilva.agiletestrestfulapi.services.CrudService;
import com.josiasdasilva.agiletestrestfulapi.services.OrderService;
import com.josiasdasilva.agiletestrestfulapi.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends CrudController <Order, Long>{
    @Autowired
    private OrderService orderService;

    @Override
    public CrudService<Order, Long> getService() {
        return orderService;
    }


}
