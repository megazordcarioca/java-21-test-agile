package com.josiasdasilva.agiletestrestfulapi.services;

import com.josiasdasilva.agiletestrestfulapi.entities.Order;
import com.josiasdasilva.agiletestrestfulapi.entities.OrderItem;
import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import com.josiasdasilva.agiletestrestfulapi.repositories.OrderItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends CrudServiceImpl<OrderItem,Long> implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository=orderItemRepository;
    }

    @Override
    protected JpaRepository<OrderItem, Long> getRepository() {
        return orderItemRepository;
    }

}
