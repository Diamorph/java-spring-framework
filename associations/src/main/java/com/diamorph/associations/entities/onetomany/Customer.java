package com.diamorph.associations.entities.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    public void addPhoneNumber(PhoneNumber phoneNumber ) {
        if (phoneNumber != null) {
            if (numbers == null) {
                numbers = new HashSet<>();
            }
            phoneNumber.setCustomer(this);
            numbers.add(phoneNumber);
        }
    }
}
