package com.microservices.order_service.exception;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException(String message) {
        super(message);
    }
}
