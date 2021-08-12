package project.swa.OrderService.service;

//@Data
public class OrderLineDTO {
    private int quantity;
    private ProductDTO product;

    public OrderLineDTO(int quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
