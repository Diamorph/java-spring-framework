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
// joined
@PrimaryKeyJoinColumn(name = "id")
// single table
//@DiscriminatorValue("ch")
@Table(name="bankcheck")
public class Check extends Payment {
    private String checkNumber;
}
