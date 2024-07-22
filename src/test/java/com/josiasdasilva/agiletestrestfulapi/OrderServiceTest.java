package com.josiasdasilva.agiletestrestfulapi;

import com.josiasdasilva.agiletestrestfulapi.entities.Order;
import com.josiasdasilva.agiletestrestfulapi.repositories.OrderRepository;
import com.josiasdasilva.agiletestrestfulapi.services.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createOrder() {
        // Configuration
        Long orderId = 1L;
        Order newOrder = new Order();
        newOrder.setId(orderId);
        newOrder.getOrderDate(new Date());

        when(orderRepository.save(any(Order.class))).thenReturn(newOrder);

        Order result = orderService.save(newOrder);
        assertNotNull(result.getId());
        assertEquals(orderId, result.getId());
        verify(orderRepository, times(1)).save(any(Order.class));

    }

    @Test
    public void findOrderByIdTest(){
        Long orderId = 1L;
        Order expectedOrder = new Order();
        expectedOrder.setId(orderId);
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(expectedOrder));
        Optional<Order> foundedOrder = orderService.findById(orderId);
        assertTrue(foundedOrder.isPresent());
        assertEquals(expectedOrder.getId(), foundedOrder.get().getId());
        verify(orderRepository, times(1)).findById(orderId);

    }

    @Test
    public void findAllOrdersTest(){
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        order1.setId(1L);
        order2.setId(2L);
        order3.setId(3L);

        List<Order> ordersList = Arrays.asList(order1, order2, order3);
        Page<Order> allOrders = new PageImpl<>(ordersList);

        int page = 0;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size);

        when(orderRepository.findAll(pageRequest)).thenReturn(allOrders);

        Page<Order> resultOrders = orderService.findAll(page,size);

        assertNotNull(resultOrders);
        assertEquals(allOrders.getSize(), resultOrders.getContent().size());
        assertTrue(resultOrders.getContent().containsAll(ordersList));
        verify(orderRepository, times(1)).findAll(pageRequest);

    }

    @Test
    public void updateOrderTest(){
        Long orderId = 1L;
        Order originalOrder = new Order();
        originalOrder.setId(orderId);
        originalOrder.getOrderDate(new Date());
        originalOrder.setOrderStatus("Created");

        Order updateOrder = new Order();
        updateOrder.setId(orderId);
        updateOrder.setOrderStatus("Pending");

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(originalOrder));
        when(orderRepository.save(any(Order.class))).thenReturn(updateOrder);

        Optional<Order> updatedOrder = orderService.findById(orderId);
        assertTrue(updatedOrder.isPresent());

        updatedOrder.get().setOrderStatus("Pending");
        Order savedOrder = orderService.save(updatedOrder.get());

        assertEquals("Pending",savedOrder.getOrderStatus());
        verify(orderRepository, times(1)).findById(orderId);

    }

    @Test
    public void deleteOrderTest(){
        Long orderId = 1L;
        Order deleteOrder = new Order();
        deleteOrder.setId(orderId);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(deleteOrder));
        doNothing().when(orderRepository).deleteById(orderId);

        Optional<Order> foundedOrder = orderService.findById(orderId);
        assertTrue(foundedOrder.isPresent());

        orderService.delete(foundedOrder.get().getId());
        verify(orderRepository, times(1)).findById(orderId);

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());
        Optional<Order> orderAfterDelete = orderService.findById(orderId);
        assertFalse(orderAfterDelete.isPresent());

    }

}
