package com.example.dioclass.apirest.ApiRestHateoas.Exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("Could not found the employee: " + id);
    }
}
