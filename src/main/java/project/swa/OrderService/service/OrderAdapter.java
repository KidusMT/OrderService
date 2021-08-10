package project.swa.OrderService.service;

import project.swa.OrderService.domain.Order;

public class OrderAdapter {
    public static Order getProduct(OrderDTO orderDTO) {
        return new Order(
                orderDTO.getOrderNumber(),
                orderDTO.getDate(),
                orderDTO.getStatus(),
                orderDTO.getCustomerDTO());
    }

    public static OrderDTO getProductDTO(Order product) {
        return new OrderDTO(product.getOrderNumber(),
                product.getDate(),
                product.getStatus(),
                product.getCustomerDTO());
    }
}
