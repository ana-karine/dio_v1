package com.example.dioclass.apirest.ApiRestHateoas.Repositories;

import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
