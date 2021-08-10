package project.swa.OrderService.service;

import lombok.Data;
import project.swa.OrderService.domain.OrderStatus;

import java.util.Date;

@Data
public class OrderDTO {
    private String orderNumber;
    private Date date;
    private OrderStatus status;
    private CustomerDTO customerDTO;

    public OrderDTO(String orderNumber, Date date, OrderStatus status, CustomerDTO customerDTO) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.status = status;
        this.customerDTO = customerDTO;
    }
}
