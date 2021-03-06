package project.swa.OrderService.service;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String zip;

    public AddressDTO(String street, String city, String zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
