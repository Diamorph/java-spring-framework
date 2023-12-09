package com.diamorph.datingapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String likes;
    private String dislikes;
    private String hobbies;
    private String profileUrl;
    private String about;
    @Transient
    private int userAccountId;
    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private UserAccount userAccount;
}
