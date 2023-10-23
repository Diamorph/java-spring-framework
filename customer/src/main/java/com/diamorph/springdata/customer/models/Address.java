package com.diamorph.springdata.customer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "streetaddress")
    private String streetAddress;
    private String city;
    private String state;
    @Column(name = "zipcode")
    private String zipCode;
    private String country;
}
