import model.Denomination;
import model.Inventory;
import model.Item;
import model.CashRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine { //TODO

	private CashRegister cashRegister;
	private Inventory inventory;
	private boolean isOperational;
	private ArrayList<Item> cart;


//	public void addToCart(String name, int quantity){
//
//	}
//
//	public void insertCash(Denomination denomination){
//
//	}

//	public ArrayList<Denomination> cancelTransaction(){
//
//	}

//	public ArrayList<Denomination> transact(){
//
//	}

//	public getcash(){
//
//	}

//	public void begin(){ //start vending machine
//
//	}
//	public Double getTotalEarnings(){
//
//	}

//    public VendingMachine(HashMap<Item, Integer> startingItems){
//		this.inventory = startingItems;
//
//    }
	
//	public void addToCart(Item item, int quantity) {
//		if (quantity > inventory.get(item)) {
//			throw new IllegalArgumentException("Current supply of " + item.getName() + " is not enough.");
//		}
//
//		cart.put(item, quantity);
//	}
	
//	public void clearCart() {
//		cart = new HashMap<>();
//	}
//
//	public Map<Item, Integer> getCart() {
//		return this.cart;
//	}
//
//	public double getTotalCostInCart() {
//		double total = 0;
//		for (var cartItem : cart.entrySet()) {
//			total += cartItem.getKey().getPrice() * cartItem.getValue();
//		}
//		return total;
//	}
//
//
//
//
//
//    // The moderator can use this for versatility.
//    public void setItem(Item item, int quantity) { // TODO revise the addItem, because this method performs setItemQuantity
//		if ( quantity > 20 ){
//            throw new IllegalArgumentException("Quantity limit exceeded for item: " + item.getName());
//        } else{
//            //System.out.printf("\tAdding item %s with quantity %d...\n", item.getName(), quantity);
//            inventory.put(item, quantity);
//        }
//    }
//
//    // The moderator can use this for convenience to ensure that the minimum criteria for the quantity is met.
//    public void setItem(Item item) { // TODO revise the addItem, because this method performs setItemQuantity
//        this.setItem(item, 10);
//    }
//
//    public Map<Item, Integer> getInventory(){ // TODO this should not print, retrieve (not printInventory but getInventory)
//        return inventory;
////        ArrayList<model.Item> items = new ArrayList<>( inventory.keySet() );
////        ArrayList<Integer> quantities = new ArrayList<>( inventory.values() );
////        System.out.println("\nInventory:");
////        for (int i = 0; i < inventory.size(); i++){
////            model.Item oneItem = items.get(i);
////            int oneQuantity = quantities.get(i);
////
////            System.out.printf("%d. %s x%d: \n\tPrice per item: %s\n", i+1, oneItem.getName(), oneQuantity, oneItem.getPrice());
//    }
}


