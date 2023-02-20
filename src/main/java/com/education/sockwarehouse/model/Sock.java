package com.education.sockwarehouse.model;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
