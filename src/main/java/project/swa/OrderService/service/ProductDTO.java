package project.swa.OrderService.service;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
    private StockDTO stockDTO;
    private List<ReviewDTO> reviewDTOS;

    public ProductDTO(String productNumber, String name, Double price, String description, StockDTO stockDTO, List<ReviewDTO> reviewDTOS) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockDTO = stockDTO;
        this.reviewDTOS = reviewDTOS;
    }
}
