package model;

import java.util.ArrayList;

public class Item {
    private String name;
    private double price;
    private double calories;

    public Item(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName(){return name;}
    public double getPrice(){return price;}
    public double getCalories() { return calories; }


    // Setter for price to allow changes in pricing
    public void setPrice(double price) {
        this.price = price;
    }
}
