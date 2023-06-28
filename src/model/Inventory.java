package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inStock = new ArrayList<>();


	private final int MAX_PER_SLOT = 20;


    public void addItem(Item item, int quantity){


        if (quantity < 0){
            throw new IllegalArgumentException("Invalid number of items! ");
        }
        for (int i = 0; i < quantity; i++){
            if (this.getQuantity(item.getName()) >= MAX_PER_SLOT) {
				break;
			}
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
    public double getPrice(String itemName){
        return this.findFirst(itemName).getPrice();
    }

    public double getCalories(String itemName){
        return this.findFirst(itemName).getCalories();
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
        return getUniqueItemNames().size();
    }

    public ArrayList<String> getUniqueItemNames(){
        ArrayList<String> uniqueNames = new ArrayList<>();
        for (Item item: this.inStock){
            String nameOfItem = item.getName();
            if (!uniqueNames.contains(nameOfItem)){
                uniqueNames.add(nameOfItem);
            }
        }
        return uniqueNames;
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
