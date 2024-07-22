package com.josiasdasilva.agiletestrestfulapi;

import com.josiasdasilva.agiletestrestfulapi.entities.Order;
import com.josiasdasilva.agiletestrestfulapi.entities.OrderItem;
import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import com.josiasdasilva.agiletestrestfulapi.repositories.OrderItemRepository;
import com.josiasdasilva.agiletestrestfulapi.services.OrderItemServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderItemServiceTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    private OrderItem orderItem;
    private Product product;
    private Order order;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    public void createOrderItemTest() {
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        OrderItem newOrderItem = new OrderItem();
        newOrderItem.setProduct(product);
        newOrderItem.setOrder(order);
        newOrderItem.setQuantity(1);

        OrderItem createdOrderItem = orderItemService.save(newOrderItem);

        verify(orderItemRepository).save(any(OrderItem.class));

        assertNotNull(createdOrderItem);
        assertEquals(product, createdOrderItem.getProduct());
        assertEquals(order, createdOrderItem.getOrder());
        assertEquals(1, createdOrderItem.getQuantity());
    }


    @Test
    public void findAllOrderItemTest() {
        int page = 0;
        int size = 10;
        Page<OrderItem> allOrderItems = new PageImpl<>(Collections.singletonList(orderItem));

        when(orderItemRepository.findAll(PageRequest.of(page, size))).thenReturn(allOrderItems);

        Page<OrderItem> itemsPage = orderItemService.findAll(page, size);

        assertNotNull(itemsPage);
        assertFalse(itemsPage.getContent().isEmpty());
        assertEquals(1, itemsPage.getContent().size());
        assertEquals(orderItem, itemsPage.getContent().get(0));
    }

    @Ignore
    public void findOrderItemByIdTest() {

        when(orderItemService.findById(1L)).thenReturn(Optional.of(orderItem));

        Optional<OrderItem> found = orderItemService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals(orderItem, found.get());

        verify(orderItemRepository).findById(1L);
    }

    @Ignore
    public void updateOrderItemTest() {

        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);
        OrderItem updatedOrderItem = orderItemService.update(orderItem.getOrder().getId(), orderItem);

        assertNotNull(updatedOrderItem);
        assertEquals(orderItem, updatedOrderItem);
        verify(orderItemRepository).save(any(OrderItem.class));
    }

    @Ignore
    public void DeleteOrderItemTest() {
        orderItemService.delete(1L);
        verify(orderItemRepository).delete(orderItem);
    }
}
