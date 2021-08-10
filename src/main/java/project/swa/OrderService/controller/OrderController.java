package project.swa.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swa.OrderService.exception.OrderNotFoundException;
import project.swa.OrderService.service.OrderDTO;
import project.swa.OrderService.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getCustomers() {
        List<OrderDTO> customerDTO1 = orderService.getAll();
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new OrderNotFoundException("Product not found");
            }
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> addCustomer(@RequestBody OrderDTO customerDTO) {
        OrderDTO customerDTO1 = orderService.add(customerDTO);
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new OrderNotFoundException("Product not found");
            }
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateCustomer(@PathVariable String id, @RequestBody OrderDTO customerDTO) {
        OrderDTO customerDTO1 = orderService.update(id, customerDTO);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new OrderNotFoundException("Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteCustomer(@PathVariable String id) {
        OrderDTO customerDTO1 = orderService.delete(id);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new OrderNotFoundException("Product not found");
        }
    }
}
