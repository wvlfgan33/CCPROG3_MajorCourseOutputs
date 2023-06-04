import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<Item, Integer> inventory = new HashMap<>();

    public void addItem(Item item, int quantity) {
        if (quantity <= 20){
            System.out.printf("\tAdding item %s with quantity %d...\n", item.getName(), quantity);
            inventory.put(item, quantity);
        }
//        else if{
//            System.out.println("\tThere is no more space for " + item.getName() + ".");
//        }
    }
    public void addItem(Item item) {
        this.addItem(item, 10);
    }

    public void printInventory(){
        ArrayList<Item> items = new ArrayList<>( inventory.keySet() );
        ArrayList<Integer> quantities = new ArrayList<>( inventory.values() );
        System.out.println("\nInventory:");
        for (int i = 0; i < inventory.size(); i++){
            Item oneItem = items.get(i);
            int oneQuantity = quantities.get(i);

            System.out.printf("%d. %s x%d: \n\tPrice per item: %s\n", i+1, oneItem.getName(), oneQuantity, oneItem.getPrice());
        }
    }

}
