package com.diamorph.compositeKey.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customerCompositeKey")
//@IdClass(CustomerId.class)
public class Customer {
//    @Id
//    private int id;
//    @Id
//    private String email;
    @EmbeddedId
    private CustomerId id;
    private String name;
}
