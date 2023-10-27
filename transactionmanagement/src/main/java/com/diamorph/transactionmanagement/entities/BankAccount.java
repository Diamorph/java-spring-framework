package com.diamorph.transactionmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;
}
