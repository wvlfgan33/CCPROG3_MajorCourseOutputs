package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inStock;
    private ArrayList<Item> oldInventory;
    private int size;
    private Summary summary;

    public Inventory(Item[] inStock, int[] quantities) {
        this.size = inStock.length;
        this.inStock = new ArrayList<>();
        this.oldInventory = new ArrayList<>();

        for (int i = 0; i < inStock.length; i++){
            for (int j = 0; j < quantities[i]; j++){
                this.inStock.add(inStock[i]);
                this.oldInventory.add(inStock[i]);
            }
        }
    }

    public void addItem(Item item){
        inStock.add(item);
    }

    public void addItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++){
            inStock.add(item);
        }

    }
    public ArrayList<Item> getInStock(){ return inStock; }

    public Item findFirst(String itemName) { //If you want to buy the item, you use this method to find that first item that you want

        for (int i = 0; i < inStock.size(); i++) {
            if (itemName.equals(inStock.get(i).getName())) {
                return inStock.get(i);
            }

        }

        throw new IllegalArgumentException("The vending machine does not have that item.");
    }

    public int getQuantity(String itemName){
        int quantity = 0;
        for (int i = 0; i < inStock.size(); i++){
            if (itemName.equals(inStock.get(i).getName())){
                quantity += 1;
            }
        }
        return quantity;
    }

    public int getUniqueItemCount(){ //Counts all the products that we have in our vending machine
        return this.size;
    }

    public ArrayList<Item> dispenseItem(String name){

        ArrayList<Item> toBeDispensed = new ArrayList<>();
        for (int i = 0; i < inStock.size(); i++){

            if (name.equals(inStock.get(i).getName())){
                toBeDispensed.add(inStock.get(i));
            }
        }

        for (int i = 0; i < toBeDispensed.size(); i++){
            inStock.remove(toBeDispensed.get(i));
        }
        return toBeDispensed;
    }




}
