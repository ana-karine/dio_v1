package com.example.dioclass.apirest.ApiRestHateoas.Controllers;

import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Employee;
import com.example.dioclass.apirest.ApiRestHateoas.Repositories.EmployeeRepository;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    // definindo o repository
    private final EmployeeRepository repository;
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    // definindo um label para o GetMapping
    // criar método do tipo lista de employees
    ResponseEntity<List<Employee>>listOfEmployeeAll() {
        List<Employee> employeeList = repository.findAll();
        long id;
        Link linkUri;

        // inserindo retorno com reponse http
        if (employeeList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        for (Employee employee : employeeList) {
            id = employee.getId();
            linkUri = linkTo(methodOn(EmployeeController.class).consultOneEmployee(id)).withSelfRel();
            employee.add(linkUri);
        }
        return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
    }

    // adicionando um employee
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Get para único employee
    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> consultOneEmployee(@PathVariable Long id) {
        // para enviar como resposta HTTP devemos setar o retorno para ResponseEntity<>
        Link linkUri;
        Optional<Employee> employeesOptional = repository.findById(id);

        if (employeesOptional.isPresent()) {
            Employee employees = employeesOptional.get();
            employees.add(linkTo(methodOn(EmployeeController.class).listOfEmployeeAll()).withRel("Employees List"));
            employees.add(linkTo(methodOn(EmployeeController.class).consultOneEmployee(id)).withSelfRel());
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // modificação parcial
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, long id) {
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setAddress(newEmployee.getAddress());
            employee.setRole(newEmployee.getRole());
            return repository.save(newEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable long id) {
        repository.deleteById(id);
    }
}
