package com.example.dioclass.apirest.ApiRestCrud;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("Could not found the employee: " + id);
    }
}
