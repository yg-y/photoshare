package com.photoshare.study.reflect;

public class Car {
    private String brand = "BWM";
    private String name = "X3";
    public String color = "Blue";

    public String print(String date) {
        return date + ":" + brand + ":" + name + ":" + color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
