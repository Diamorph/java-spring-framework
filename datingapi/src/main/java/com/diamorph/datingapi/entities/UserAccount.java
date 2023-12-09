package com.diamorph.datingapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private int age;
    private String email;
    private String phoneNumber;
    private String gender;
    private String city;
    private String country;
    @OneToOne(mappedBy = "userAccount")
    private Interest interest;
}
