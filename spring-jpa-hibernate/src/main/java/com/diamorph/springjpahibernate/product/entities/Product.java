package com.diamorph.springjpahibernate.product.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
    @Id
    private int id;
    private String name;
    @Column(name = "description")
    private String desc;
    private Double price;
}
