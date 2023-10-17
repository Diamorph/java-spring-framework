package com.diamorph.springdata.hibernateinheritance.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
// joined
@Inheritance(strategy = InheritanceType.JOINED)
// table per class
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// single table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="pmode", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {
    @Id
    private int id;
    private double amount;
}
