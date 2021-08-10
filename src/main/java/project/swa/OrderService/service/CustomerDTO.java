package project.swa.OrderService.service;

import lombok.Data;

@Data
public class CustomerDTO {
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private AddressDTO address;

    public CustomerDTO(String customerId, String firstName, String lastName, String phoneNumber, String email, AddressDTO address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
