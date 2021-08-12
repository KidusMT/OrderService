package project.swa.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.swa.OrderService.data.OrderRepository;
import project.swa.OrderService.domain.Order;
import project.swa.OrderService.exception.OrderNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderAdapter::getProductDTO).toList();
    }

    public List<OrderDTO> getById(String id) {
        return orderRepository.findById(id).stream().map(OrderAdapter::getProductDTO).toList();
    }

    public OrderDTO add(OrderDTO orderDTO) {
        Order customer = orderRepository.save(OrderAdapter.getProduct(orderDTO));
        return OrderAdapter.getProductDTO(customer);
    }

    public OrderDTO update(String id, OrderDTO orderDTO) {
        Optional<Order> customerDTO1 = orderRepository.findById(id);
        if (customerDTO1.isPresent()) {
            orderDTO.setOrderNumber(id);
            Order customer = orderRepository.save(OrderAdapter.getProduct(orderDTO));
            return OrderAdapter.getProductDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }

    public OrderDTO delete(String customerId) throws OrderNotFoundException {
        Optional<Order> customerOptional = orderRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Order customer = customerOptional.get();
            orderRepository.delete(customer);
            return OrderAdapter.getProductDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }
}
