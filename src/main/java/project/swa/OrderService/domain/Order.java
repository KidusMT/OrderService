package project.swa.OrderService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import project.swa.OrderService.service.CustomerDTO;

import java.util.Date;
import java.util.List;

//@Data
@Document(collection = "ORDER")
public class Order {
    @Id
    private String orderNumber;
    private Date date;
    private OrderStatus status;
    private CustomerDTO customerDTO;

    public Order(String orderNumber, Date date, OrderStatus status, CustomerDTO customerDTO) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.status = status;
        this.customerDTO = customerDTO;
    }


    public void confirm(){
        status = OrderStatus.PLACED;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}
