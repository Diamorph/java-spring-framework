package com.diamorph.jpglandnativesql.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    private int score;
}
