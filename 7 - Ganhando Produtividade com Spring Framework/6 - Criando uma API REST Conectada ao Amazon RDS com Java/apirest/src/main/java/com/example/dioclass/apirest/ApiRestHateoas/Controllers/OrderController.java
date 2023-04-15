package com.example.dioclass.apirest.ApiRestHateoas.Controllers;

import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Order;
import com.example.dioclass.apirest.ApiRestHateoas.Entitys.Status;
import com.example.dioclass.apirest.ApiRestHateoas.Exceptions.OrderNotFoundException;
import com.example.dioclass.apirest.ApiRestHateoas.Repositories.OrderRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OrderController {

    // definindo o repository
    private final OrderRepository repositoryOrder;

    public OrderController(OrderRepository repository) {
        this.repositoryOrder = repository;
    }

    @GetMapping("/orders")
    ResponseEntity<List<Order>> consultOrderAll() {
        long idOrder;
        Link linkUri;
        List<Order> orderList = repositoryOrder.findAll();

        if (orderList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        for (Order order : orderList) {
            idOrder = order.getId();
            linkUri = linkTo(methodOn(OrderController.class).consultOneOrder(idOrder)).withSelfRel();
            order.add(linkUri);
            linkUri = linkTo(methodOn(OrderController.class).consultOrderAll()).withRel("Customer order list");
            order.add(linkUri);
        }
        return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);

    }

    @GetMapping("/orders/{id}")
    ResponseEntity<Order> consultOneOrder(@PathVariable Long id) {
        Optional<Order> orderPointer = repositoryOrder.findById(id);

        if (orderPointer.isPresent()) {
            Order order = orderPointer.get();
            order.add(linkTo(methodOn(OrderController.class).consultOrderAll()).withRel("All orders"));
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // adicionando um employee
    @PostMapping("/orders")
    Order newOrder(@RequestBody Order newOrder) {
        return repositoryOrder.save(newOrder);
    }

    // modificação parcial
    @PutMapping("/orders/{id}")
    Order replaceOrder(@RequestBody Order newOrder, long id) {
        return repositoryOrder.findById(id).map(order -> {
            order.setDescription(newOrder.getDescription());
            order.setStatus(newOrder.getStatus());
            return repositoryOrder.save(newOrder);
        }).orElseGet(() -> {
            newOrder.setId(id);
            return repositoryOrder.save(newOrder);
        });
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable long id) {
        repositoryOrder.deleteById(id);
    }

    @PutMapping("/orders/{id}/cancel")
    public ResponseEntity<?> cancelOrderById(@PathVariable long id) {
        Order cancelledOrder = repositoryOrder.findById(id).orElseThrow(
                () -> new OrderNotFoundException(id));
        if (cancelledOrder.getStatus() == Status.IN_PROGRESS) {
            cancelledOrder.setStatus(Status.CANCELLED);
            cancelledOrder.add(linkTo(methodOn(OrderController.class).consultOneOrder(id)).withSelfRel());
            cancelledOrder.add(linkTo(methodOn(OrderController.class).consultOrderAll())
                    .withRel("Complete order list"));
            repositoryOrder.save(cancelledOrder);
            return new ResponseEntity<>(cancelledOrder,HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body("You can't complete the task, the order has a " +
                        cancelledOrder.getStatus() + " status");
    }

    @PutMapping("/orders/{id}/complete")
    public ResponseEntity<?> completeOrderById(@PathVariable long id) {
        Order cancelledOrder = repositoryOrder.findById(id).orElseThrow(
                () -> new OrderNotFoundException(id));
        if (cancelledOrder.getStatus() == Status.IN_PROGRESS){
            cancelledOrder.setStatus(Status.COMPLETED);
            cancelledOrder.add(linkTo(methodOn(OrderController.class).consultOneOrder(id)).withSelfRel());
            cancelledOrder.add(linkTo(methodOn(OrderController.class).consultOrderAll())
                    .withRel("Complete order list"));
            repositoryOrder.save(cancelledOrder);
            return new ResponseEntity<>(cancelledOrder,HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE,
                        MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body("You can't complete the task, the order has a " +
                        cancelledOrder.getStatus() + " status");
    }

}
