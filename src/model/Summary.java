package model;

import java.util.ArrayList;

public class Summary {

    private ArrayList<Item> initialInventory = new ArrayList<>();
	private Inventory inventory;
    private ArrayList<Item> sales = new ArrayList<>();

	public Summary(Inventory inventory){
		this.inventory = inventory;
	}

    // TODO From here up to bottom
	public ArrayList<Item> getInitialInventory(){
		ArrayList<Item> initialInventory = new ArrayList<>();
		initialInventory.addAll(this.initialInventory);
		return initialInventory;
	}
    public void setInitialInventory(ArrayList<Item> inStock) {
        this.initialInventory = new ArrayList<>();
		this.initialInventory.addAll(inStock);
    }
	public ArrayList<Item> getCurrentInventory(){
		ArrayList<Item> finalInventory = new ArrayList<>();
		finalInventory.addAll(this.inventory.getInStock());
		return finalInventory;
	}

    public void recordSales(ArrayList<Item> dispensedItems){
		this.sales.addAll(dispensedItems);
    }

    public double computeTotalEarnings(){
        double total = 0;
		for (Item item : sales) {
			total += item.getPrice();
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

	public ArrayList<Item> getSales() {
		ArrayList<Item> sales = new ArrayList<>();
		sales.addAll(this.sales);
		return sales;
	}
	
	public ArrayList<String> getUniqueItemNamesInSales(){
        ArrayList<String> uniqueNames = new ArrayList<>();
        for (Item item: this.sales){
            String nameOfItem = item.getName();
            if (!uniqueNames.contains(nameOfItem)){
                uniqueNames.add(nameOfItem);
            }
        }
        return uniqueNames;
    }

	public ArrayList<String> getUniqueItemsNamesIniInventory() {
		ArrayList<String> unique = new ArrayList<String>();
		for (Item item : this.initialInventory) {
			if (!unique.contains(item.getName())) {
				unique.add(item.getName());
			}
		}
		return unique;
	}
	
	public int countItemInInitialInventory(String itemName) {
		int count = 0;
		for (var ini : this.initialInventory) {
			if (itemName.equals(ini.getName())) {
				count++;
			}
		}
		return count;
	}
	
//	public void generateReceipt(ArrayList<Item> cartItems, double priceOfItems) {
//		this.receipt = "";
//		String result = "Items:\n";
//		for (Item i : cartItems) {
//			result += "- " + i.getName() + "\n";
//		}
//		result += "\nTotal Price: " + String.valueOf(priceOfItems);
//
//		this.receipt = result;
//	}
	
//	public String getReceipt() {
//		return this.receipt;
//	}
	

}
