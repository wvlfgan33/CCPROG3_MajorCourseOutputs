import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){

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

		CashRegister cashRegister = new CashRegister();
		cashRegister.addCash(Denomination.ONE_HUNDRED, 8);
		cashRegister.addCash(Denomination.FIFTY, 4);
		cashRegister.addCash(Denomination.TWENTY, 4);
		cashRegister.addCash(Denomination.TEN, 4);
		cashRegister.addCash(Denomination.FIVE, 1);
		cashRegister.addCash(Denomination.ONE, 4);

		ArrayList<Denomination> vendingMachineCash = cashRegister.getCashList();


		ArrayList<Denomination> myMoney = new ArrayList<>();
		myMoney.add(Denomination.ONE_THOUSAND);
		myMoney.add(Denomination.ONE_HUNDRED);
////		myMoney.add(Denomination.FIFTY);
//		ArrayList<Denomination> change = cashRegister.transact(myMoney, 150);
//
//		System.out.println(change);
//		System.out.println(cashRegister.getCashList());

		Item item1 = new Item("Coke", 20.00, 139);
		Item item2 = new Item("Pepsi", 20.00, 139);
		Item item3 = new Item("St. Miguel Beer",40.00,43);
		Item item4 = new Item("St. Joseph Beer",45.00, 43);
		Item item5 = new Item("Cheetos King Size", 69.00,160);
		Item item6 = new Item("Cheddar Pringles", 80.00,140);
		Item item7 = new Item("Bottled Water", 15.00, 0);
		Item item8 = new Item("Standard Gelato", 100.00,207);
		Item item9 = new Item("Chocolate Syrup", 20.00,279);

		VendingMachine v = new VendingMachine();
		Inventory inventory = new Inventory();
		inventory.addItem(item1);
		inventory.addItem(item2);
		inventory.addItem(item3);
		inventory.addItem(item4);
		inventory.addItem(item5);
		inventory.addItem(item6);

		for (int i = 0; i < inventory.getInStock().toArray().length; i++){
			System.out.println( inventory.getInStock().get(i).getName() + " | " + inventory.getInStock().get(i).getPrice()+ " | "
			+ inventory.getInStock().get(i).getCalories());

		}
    }




}