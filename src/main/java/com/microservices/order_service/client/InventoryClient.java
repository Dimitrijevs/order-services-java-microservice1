package com.microservices.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8083", path = "/api/inventory")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/availability")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
