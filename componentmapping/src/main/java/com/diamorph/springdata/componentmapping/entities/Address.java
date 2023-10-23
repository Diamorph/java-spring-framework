package com.diamorph.springdata.componentmapping.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "streetaddress")
    private String streetAddress;
    private String city;
    private String state;
    @Column(name = "zipcode")
    private String zipCode;
    private String country;
}
