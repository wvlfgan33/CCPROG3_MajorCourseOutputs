package model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inStock = new ArrayList<>();
    private Summary summary;

    public void addItem(Item item){
        inStock.add(item);

    }

    public ArrayList<Item> getInStock(){ return inStock; }

    public Item findFirst(String itemName){
        Item itemDummy = new Item("DummyItem", 23.0, 2031.0);
        return itemDummy;
    }

    public int getQuantity(String itemName){
        return 1;
    }

    public int getUniqueItemCount(){ //Counts all the products that we have in our vending machine
        return 1;
    }

    public ArrayList<Item> dispenseItem(){
        ArrayList<Item> dummyitem = new ArrayList<>();
        return dummyitem;
    }




}
