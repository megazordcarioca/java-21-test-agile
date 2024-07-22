package com.josiasdasilva.agiletestrestfulapi.repositories;

import com.josiasdasilva.agiletestrestfulapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
