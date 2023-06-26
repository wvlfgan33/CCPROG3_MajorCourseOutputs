import model.*;

import java.util.HashMap;
import java.util.Map;
public class Main{
    public static void main(String[] args){

        // model.Item definition
        Item item1 = new Item("Coke", 20.00, 139);
        Item item2 = new Item("Pepsi", 20.00, 139);
        Item item3 = new Item("St. Miguel Beer",40.00,43);
        Item item4 = new Item("St. Joseph Beer",45.00, 43);
        Item item5 = new Item("Cheetos King Size", 69.00,160);
        Item item6 = new Item("Cheddar Pringles", 80.00,140);
        Item item7 = new Item("Bottled Water", 15.00, 0);
		Item item8 = new Item("Standard Gelato", 100.00,207);
		
        //Item item8 = new Item("Standard Gelato", 100.00,207);
        //Item item9 = new Item("Chocolate Syrup", 20.00,279);


        // Vending Machine
		
		HashMap<Item, Integer> items = new HashMap<>();
		items.put(item1, 11);
		items.put(item2, 11);
		items.put(item3, 11);
		items.put(item4, 11);
		items.put(item5, 11);
		items.put(item6, 11);
		items.put(item7, 11);
		items.put(item8, 11);
	
        VendingMachine m = new VendingMachine(items);
//        m.addItem(item1);
		  //m.setItem(item2, 17);
//        m.addItem(item3,9);
//        m.addItem(item4, 21);
//        m.addItem(item5);
//        m.addItem(item6);
//        m.addItem(item7);
//        m.addItem(item8);
//        m.addItem(item9);

//        m.printInventory();

		//System.out.println(m.getInventory());
		
		m.addToCart(item1, 3);
		m.addToCart(item3, 10);
		m.addToCart(item4, 10);
		m.addToCart(item7, 10);
		
		for (var item : m.getCart().entrySet()) {
			System.out.println(item.getKey().getName() + ", x" + item.getValue());
		}	

		System.out.println(m.getTotalCostInCart());
		
		Money moneyyy = new Money(100,100,100,100,100,100,100,100,100);
		
		try {
			Money a = new Money(0,0,0,1,0,0,0,0,0);
			Money b = new Money(1,1,1,0,0,0,0,0,0);
			
			Money difference = moneyyy.subtract(a, b);
			
			System.out.println("--------------------------------------");
			for (var d : difference.getMoney().entrySet()) {
				System.out.println(d.getKey().getValue() + " pesos, x" + d.getValue());
			}
			System.out.println("--------------------------------------");
			for (var d : moneyyy.getMoney().entrySet()) {
				System.out.println(d.getKey().getValue() + " pesos, x" + d.getValue());
			}
			
		} catch (Exception e) {
			System.out.println("not enough money");
		}
    }
}