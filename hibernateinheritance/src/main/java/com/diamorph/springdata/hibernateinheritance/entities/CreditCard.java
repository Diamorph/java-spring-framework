package com.diamorph.springdata.hibernateinheritance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "card")
// joined
@PrimaryKeyJoinColumn(name = "id")
// single table
//@DiscriminatorValue("cc")
public class CreditCard extends Payment {
    private String cardNumber;
}
