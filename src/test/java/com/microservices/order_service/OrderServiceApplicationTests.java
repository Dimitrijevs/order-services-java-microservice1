package com.microservices.order_service;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
class OrderServiceApplicationTests {

    @Test
    void shouldCreateOrder() {

    }
}