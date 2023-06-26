import model.Denomination;
import model.Item;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<Item, Integer> inventory = new HashMap<>();
    private Map<Item, Integer> oldInventory;
    private Map<Denomination, Integer> cash;
    private Map<Item, Integer> cart;
    private Double totalEarnings;
    private Integer minSlots;
    private Integer maxSlots;

    public VendingMachine(){

    }

    // The moderator can use this for versatility.
    public void setItem(Item item, int quantity) { // TODO revise the addItem, because this method performs setItemQuantity

        if ( quantity < 8 ){
            throw new IllegalArgumentException("Not enough quantity for item: " + item.getName());
        }
        else if ( quantity > 20 ){
            throw new IllegalArgumentException("Quantity limit exceeded for item: " + item.getName());
        }
        else{
            //System.out.printf("\tAdding item %s with quantity %d...\n", item.getName(), quantity);
            inventory.put(item, quantity);
        }
    }

    // The moderator can use this for convenience to ensure that the minimum criteria for the quantity is met.
    public void setItem(Item item) { // TODO revise the addItem, because this method performs setItemQuantity
        this.setItem(item, 10);
    }

    public Map<Item, Integer> getInventory(){ // TODO this should not print, retrieve (not printInventory but getInventory)
        return inventory;
//        ArrayList<model.Item> items = new ArrayList<>( inventory.keySet() );
//        ArrayList<Integer> quantities = new ArrayList<>( inventory.values() );
//        System.out.println("\nInventory:");
//        for (int i = 0; i < inventory.size(); i++){
//            model.Item oneItem = items.get(i);
//            int oneQuantity = quantities.get(i);
//
//            System.out.printf("%d. %s x%d: \n\tPrice per item: %s\n", i+1, oneItem.getName(), oneQuantity, oneItem.getPrice());
        }
}


