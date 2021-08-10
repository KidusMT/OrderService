package project.swa.OrderService.service;

import lombok.Data;

@Data
public class StockDTO {
    private int numberInStock;
    private String locationCode;

    public StockDTO(int numberInStock, String locationCode) {
        this.numberInStock = numberInStock;
        this.locationCode = locationCode;
    }
}
