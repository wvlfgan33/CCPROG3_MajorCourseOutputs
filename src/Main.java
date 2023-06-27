import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {

		// model.Item definition


		// Vending Machine


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

//		m.addToCart(item1, 3);
//		m.addToCart(item3, 10);
//		m.addToCart(item4, 10);
//		m.addToCart(item7, 10);
//
//		for (var item : m.getCart().entrySet()) {
//			System.out.println(item.getKey().getName() + ", x" + item.getValue());
//		}
//
//		System.out.println(m.getTotalCostInCart());
		// Mymoney = 200
		// Price of item = 237


////		myMoney.add(Denomination.FIFTY);
//		ArrayList<Denomination> change = cashRegister.transact(myMoney, 150);
//
//		System.out.println(change);
//		System.out.println(cashRegister.getCashList());

		Item item1 = new Item("Coke", 20.00, 139);
		Item item2 = new Item("Pepsi", 20.00, 139);
		Item item3 = new Item("St. Miguel Beer", 40.00, 43);
		Item item4 = new Item("St. Joseph Beer", 45.00, 43);
		Item item5 = new Item("Cheetos", 69.00, 160);
		Item item6 = new Item("Cheddar Pringles", 80.00, 140);
		Item item7 = new Item("Bottled Water", 15.00, 0);
		Item item8 = new Item("Standard Gelato", 100.00, 207);
		Item item9 = new Item("Chocolate Syrup", 20.00, 279);


//		VendingMachine v = new VendingMachine();
		Item[] items = {item1, item2, item3, item4, item5};
		int[] quantities = {3, 5, 5, 5, 7};

		VendingMachine v = new VendingMachine(items, quantities);
		CashRegister cashRegister = v.getCashRegister();
		cashRegister.addCash(Denomination.ONE_HUNDRED, 8);
		cashRegister.addCash(Denomination.FIFTY, 4);
		cashRegister.addCash(Denomination.TWENTY, 4);
		cashRegister.addCash(Denomination.TEN, 4);
		cashRegister.addCash(Denomination.FIVE, 1);
		cashRegister.addCash(Denomination.ONE, 4);

		v.addToCart("Cheetos", 2);
		v.addToCart("Pepsi", 1);

		for (int i = 0; i < v.getCart().size(); i++){
			System.out.println(v.getCart().get(i).getName());
		}
		System.out.println(v.getTotalCostInCart());

		System.out.println("Inventory: ");

		ArrayList<Item> stockList= v.getInventory().getInStock();
		for (Item item: stockList){
			System.out.println(item.getName());
		}

		ArrayList<Denomination> myMoney = new ArrayList<>();
		myMoney.add(Denomination.ONE_HUNDRED);
		myMoney.add(Denomination.ONE_HUNDRED);
		System.out.println(v.payForCart(myMoney));

		ArrayList<Item> currentStockList = v.getInventory().getInStock();
		for (Item item: currentStockList){
			System.out.println(item.getName());
		}
		System.out.println("----------------------------------");
		System.out.println(v.getReceipt());
		
		System.out.println(v.getSummaryOfOperations());


//		System.out.println(change);
//		System.out.println(cashRegister.getCashList());
////
//
//		System.out.println(inventory.getUniqueItemCount());


//		System.out.println(inventory.getQuantity("Coke"));
//		System.out.println(inventory.findFirst("Coke").getName());
//		for (int i = 0; i < inventory.getInStock().size(); i++) {
//			System.out.println(inventory.getInStock().get(i).getName() + " | " + inventory.getInStock().get(i).getPrice() + " | "
//					+ inventory.getInStock().get(i).getCalories());
//		}
//		System.out.println("-----------------------");
//		ArrayList<Item> beast = inventory.dispenseItem("Coke", 3);
//		for (Item item : beast) {
//			System.out.println(item.getName());
//		}
//		System.out.println("-----------------------");
//		for (int i = 0; i < inventory.getInStock().size(); i++) {
//			System.out.println(inventory.getInStock().get(i).getName() + " | " + inventory.getInStock().get(i).getPrice() + " | "
//					+ inventory.getInStock().get(i).getCalories());
//		}

	}
}



