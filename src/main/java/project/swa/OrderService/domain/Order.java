package project.swa.OrderService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import project.swa.OrderService.service.CustomerDTO;

import java.util.Date;
import java.util.List;

@Data
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
}
