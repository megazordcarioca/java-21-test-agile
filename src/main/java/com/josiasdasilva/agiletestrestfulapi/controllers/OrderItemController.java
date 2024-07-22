package com.josiasdasilva.agiletestrestfulapi.controllers;

import com.josiasdasilva.agiletestrestfulapi.entities.OrderItem;
import com.josiasdasilva.agiletestrestfulapi.services.CrudService;
import com.josiasdasilva.agiletestrestfulapi.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController extends CrudController<OrderItem, Long> {
    @Autowired
    private OrderItemService orderItemService;

    public CrudService<OrderItem, Long> getService() {
        return orderItemService;
    }

}
