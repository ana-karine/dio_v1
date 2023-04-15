package com.example.dioclass.apirest.ApiRestHateoas;

import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Employee;
import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Order;
import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Status;
import com.example.dioclass.apirest.ApiRestHateoas.Repositories.EmployeeRepository;
import com.example.dioclass.apirest.ApiRestHateoas.Repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);
    // persistindo dados no banco com jpa

    @Bean
    CommandLineRunner loaddata(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            log.info("Log of save event: " + employeeRepository.save(new Employee("Maria Silva", "Chef",
                    "Avenida Silveira Dutra - 1002")));
            log.info("Log of save event: " + employeeRepository.save(new Employee("John Dutra", "Mecânico",
                    "Rua João Freire - 231")));
            log.info("Log of save event: " + employeeRepository.save(new Employee("Bilbo Baggins", "Ladrão",
                    "The shine")));
            orderRepository.save(new Order(Status.COMPLETED, "review"));
            orderRepository.save(new Order(Status.IN_PROGRESS, "travel"));
            orderRepository.save(new Order(Status.IN_PROGRESS, "sale"));
            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
