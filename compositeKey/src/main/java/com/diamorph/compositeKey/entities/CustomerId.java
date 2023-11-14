package com.diamorph.compositeKey.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CustomerId implements Serializable {
    private int id;
    private String email;
}
