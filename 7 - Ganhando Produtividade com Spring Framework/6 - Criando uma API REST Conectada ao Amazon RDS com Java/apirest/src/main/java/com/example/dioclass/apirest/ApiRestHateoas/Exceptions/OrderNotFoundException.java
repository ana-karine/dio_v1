package com.example.dioclass.apirest.ApiRestHateoas.Exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super("Could not found the order id: " + id);
    }
}
