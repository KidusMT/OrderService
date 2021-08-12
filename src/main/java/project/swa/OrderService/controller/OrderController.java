package project.swa.OrderService.controller;

import org.slf4j.*;
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
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class.getName());
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getCustomers() {
        logger.info("Calling GET /order");
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

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDTO>> getCustomer(@PathVariable String id) {
        logger.info("Calling GET /order");
        List<OrderDTO> customerDTO1 = orderService.getById(id);
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
        logger.info("Calling POST /order");
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
        logger.info("Calling PUT /order");
        OrderDTO customerDTO1 = orderService.update(id, customerDTO);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new OrderNotFoundException("Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteCustomer(@PathVariable String id) {
        logger.info("Calling DELETE /order");
        OrderDTO customerDTO1 = orderService.delete(id);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new OrderNotFoundException("Product not found");
        }
    }
}
