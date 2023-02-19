package com.education.sockwarehouse.model;
import lombok.Data;


@Data
public class EntrySocks {
    private String color;
    private int cottonPart;
    private int quantity;

    public EntrySocks() {

    }
    public EntrySocks(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

}


