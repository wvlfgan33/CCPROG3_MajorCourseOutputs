package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Summary {
    private ArrayList<Item> initialInventory;
    private ArrayList<Item> sales;
    private Inventory inventory;

    // TODO From here up to bottom
    public void setInitialInventory() {
        this.initialInventory = initialInventory;
    }

    public void recordSales(ArrayList<Item> dispensedItems){

    }

    public double computeTotalEarnings(){
        return 0;
    }

    public int getQuantitySold(String itemName){
        return 0;
    }

    public ArrayList<Item> getFinalInventory(){
        ArrayList<Item> dummyItemList = new ArrayList<>();

        return dummyItemList;
    }
}
