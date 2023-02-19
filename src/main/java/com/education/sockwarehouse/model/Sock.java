package com.education.sockwarehouse.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Sock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String color;
    private int cottonPart;

    private int numberOfSocks;


    public Sock() {

    }

    public Sock(String color, int cottonPart, int numberOfSocks) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.numberOfSocks = numberOfSocks;
    }
}
