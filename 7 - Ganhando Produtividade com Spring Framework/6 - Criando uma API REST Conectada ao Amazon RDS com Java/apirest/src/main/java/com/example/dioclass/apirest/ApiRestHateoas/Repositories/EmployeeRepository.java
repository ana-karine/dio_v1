package com.example.dioclass.apirest.ApiRestHateoas.Repositories;

import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
