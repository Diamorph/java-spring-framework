package com.diamorph.springdata.idgenerators.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
//    @TableGenerator(name="employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    @GenericGenerator(name="emp_id", strategy = "com.diamorph.springdata.idgenerators.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    private Long id;
    private String name;
}
