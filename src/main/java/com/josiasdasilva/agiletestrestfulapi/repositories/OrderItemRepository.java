package com.josiasdasilva.agiletestrestfulapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josiasdasilva.agiletestrestfulapi.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
