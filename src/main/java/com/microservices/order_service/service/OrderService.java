package com.microservices.order_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservices.order_service.dto.OrderRequest;
import com.microservices.order_service.dto.OrderResponse;
import com.microservices.order_service.model.Order;
import com.microservices.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .build();

        orderRepository.save(order);
    }

    public List<OrderResponse> showAll() {
        return orderRepository.findAll()
            .stream()
            .map(order -> new OrderResponse(order.getId(), order.getOrderNumber(), order.getSkuCode(), order.getPrice(), order.getQuantity()))
            .toList();
    }
}
