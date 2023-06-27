package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Summary {
	private Item[] itemLineup;
	
    private ArrayList<Item> initialInventory = new ArrayList<>();;
    private ArrayList<Item> sales = new ArrayList<>();
	
	private ArrayList<Double> monetaryEarnings = new ArrayList<>();;
	private String receipt;

	public void setInitialItemLineup(Item[] supportedItems) {
		this.itemLineup = supportedItems;
	}

    // TODO From here up to bottom
    public void setInitialInventory() {
        this.initialInventory = initialInventory;
    }

    public void recordSales(ArrayList<Item> dispensedItems){
		this.sales.addAll(dispensedItems);
    }
	
	public void addEarnings(double i) {
		this.monetaryEarnings.add(i);
	}

    public double computeTotalEarnings(){
        double total = 0;
		for (double earns : this.monetaryEarnings) {
			total += earns;
		}
		return total;
    }

    public int getQuantitySold(String itemName){
        int count = 0;
		
		for (Item soldItems : sales) {
			if (itemName.equals(soldItems.getName())) {
				count++;
			}
		}
		return count;
    }

    public ArrayList<Item> getFinalInventory(){
        ArrayList<Item> dummyItemList = new ArrayList<>();

        return dummyItemList;
    }
	
	public ArrayList<Item> getSales() {
		return this.sales;
	}
	
	public void generateReceipt(ArrayList<Item> cartItems, double priceOfItems) {
		this.receipt = "";
		String result = "Items:\n";
		for (Item i : cartItems) {
			result += "- " + i.getName() + "\n";	
		}
		result += "\nTotal Price: " + String.valueOf(priceOfItems);
		
		this.receipt = result;
	}
	
	public String getReceipt() {
		return this.receipt;
	}
	
	public String getSummaryOfOperations() {
		String salesSummary = "Overall Items Sold:\n";
		for (Item i : this.itemLineup) {
			salesSummary += "x" + String.valueOf(this.getQuantitySold(i.getName())) + " " + i.getName() + "\n";
		}
		
		return salesSummary + "Total earnings: " + String.valueOf(this.computeTotalEarnings());
	}
}
