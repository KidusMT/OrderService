package project.swa.OrderService.domain;

import lombok.Data;
import project.swa.OrderService.service.ProductDTO;

@Data
public class OrderLine {
    private int quantity;
    private ProductDTO product;

    public OrderLine(int quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }
}
