import model.*;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.start();

//
//		Item item1 = new Item("Coke", 20.00, 139);
//		Item item2 = new Item("Pepsi", 20.00, 139);
//		Item item3 = new Item("St. Miguel Beer", 40.00, 43);
//		Item item4 = new Item("St. Joseph Beer", 45.00, 43);
//		Item item5 = new Item("Cheetos", 69.00, 160);
//		Item item6 = new Item("Cheddar Pringles", 80.00, 140);
//		Item item7 = new Item("Bottled Water", 15.00, 0);
//		Item item8 = new Item("Standard Gelato", 100.00, 207);
//		Item item9 = new Item("Chocolate Syrup", 20.00, 279);
//
//
//
//		VendingMachineService v = new VendingMachineService();
//		CashRegister cashRegister = v.getCashRegister();
//		cashRegister.addCash(Denomination.ONE_HUNDRED, 8);
//		cashRegister.addCash(Denomination.FIFTY, 4);
//		cashRegister.addCash(Denomination.TWENTY, 4);
//		cashRegister.addCash(Denomination.TEN, 4);
//		cashRegister.addCash(Denomination.FIVE, 1);
//		cashRegister.addCash(Denomination.ONE, 4);
//
//		v.addToCart("Cheetos", 2);
//		v.addToCart("Pepsi", 1);
//
//		for (int i = 0; i < v.getCart().size(); i++){
//			System.out.println(v.getCart().get(i).getName());
//		}
//		System.out.println(v.getTotalCostInCart());
//
//		System.out.println("Inventory: ");
//
//		ArrayList<Item> stockList= v.getInventory().getInStock();
//		for (Item item: stockList){
//			System.out.println(item.getName());
//		}
//
//		ArrayList<Denomination> myMoney = new ArrayList<>();
//		myMoney.add(Denomination.ONE_HUNDRED);
//		myMoney.add(Denomination.ONE_HUNDRED);
//		System.out.println(v.payForCart(myMoney));
//
//		ArrayList<Item> currentStockList = v.getInventory().getInStock();
//		for (Item item: currentStockList){
//			System.out.println(item.getName());
//		}



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



