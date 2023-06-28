import java.util.ArrayList;
import java.util.Scanner;
import model.Denomination;
import model.Item;

public class VendingMachine {
	Scanner scanner = new Scanner(System.in);
	private VendingMachineService vendingMachineService;
	private int choice = -1;

	/*
		Scene -1: Starting screen
		
		Scene 1: Start up Vending Machine
			Scene 11: Using vending machine as a customer
			Scene 12: Adding items to cart
			Scene 13: Giving payment
			
		Scene 2: Vending Machine management/setup -- Admin things
		    scene 14: Test vending features
		    scene 15: Test maintenance features
		    scene 16: exit test of a vending machine and goes back to the main menu
		
		Scene 3: Terminate Program
		
	*/
	public void start() {



		while (choice != 3) {
			System.out.println("CCPROG3 Vending Machine");
			System.out.println("Menu: ");
			System.out.println("1. Create a Vending Machine.\n2. Test/Manage/Setup a Vending Machine\n3. Exit");
			System.out.print("Enter 1, 2, or 3: ");

			choice = scanner.nextInt();

			if (choice == 1) { // 1. Create a vending machine
				this.choice = 1;
				this.vendingMachineService = new VendingMachineService();

			} else if (choice == 2) { // 2. Test a vending machine
				this.testVendingMachine();

			} else if (choice == 3) { // 3. Exit
				scanner.close();

			} else {
				System.out.println("Wrong input!");
			}

		}
	}

	// Scenes
//    private void createVendingMachine(){

//		while (this.choice == 1) {
//			try {
//				this.vendingMachineService.begin();
//				this.choice = 11;
//                this.useVendingMachineAsCustomer();
//
//			} catch (Exception e) {
//				System.out.println("Failed to start Vending Machine!");
//				System.out.println(e);
//				this.choice = -1;
//				this.start();
//			}
//		}

//    }


	private void testVendingMachine() {

		System.out.println("Test the vending machine: ");
		System.out.println("1. Test the vending features.\n2. Test the maintenance features.\n3. Exit");
		int choice1 = scanner.nextInt();
		while (choice1 == 1) { //1. Test a vending machine.
			int userChoice = scanner.nextInt();
			System.out.println("Test the vending machine:");
			System.out.println("What would you like to do?");
			System.out.println("1. Use vending machine\n2. Add items to cart\n3. Proceed to checkout");


			if (userChoice == 1) {
				this.useVendingMachineAsCustomer();
			} else if (userChoice == 2) {
				this.addToCartMenu();
			} else if (userChoice == 3) {
				this.givePaymentAndCheckout();
				choice1 = 4;

			}
		}

		while (choice1 == 2) { //2. Test maintenance features.

			System.out.println("Test maintenance features of the vending machine: ");
			System.out.println("What would you like to do?");
			System.out.println("1. Restock/stock items or setting price of each item type\n2. Replenish/add money in the Vending Machine or collect money \n3. Print summary of transactions");
			int maintenanceChoice = scanner.nextInt();

			if (maintenanceChoice == 1) {
				this.manageItems();
			}

			else if(maintenanceChoice == 2){
				//this.manageMoney();
			}

			else if (maintenanceChoice == 3){
				//this.printSummaryOfTransactions();
			}
		}
	}

	private void manageItems() {

		int maintenanceChoice1 = scanner.nextInt();
		while ()
		System.out.println("Manage items: ");
		System.out.println("1. Automatic products insertion\n2. Manual product insertion.\n3. Restock items\n4. Exit");
		System.out.println("What would you like to do?");
		int maintenanceChoice = scanner.nextInt();

		if (maintenanceChoice == 1) {

			Item item1 = new Item("Coke", 20.00, 139);
			Item item2 = new Item("Pepsi", 20.00, 139);
			Item item3 = new Item("St. Miguel Beer", 40.00, 43);
			Item item4 = new Item("St. Joseph Beer", 45.00, 43);
			Item item5 = new Item("Cheetos", 69.00, 160);
			Item item6 = new Item("Cheddar Pringles", 80.00, 140);
			Item item7 = new Item("Bottled Water", 15.00, 0);
			Item item8 = new Item("Coffee", 100.00, 207);
			Item item9 = new Item("Chocolate Syrup", 20.00, 279);
			Item item10 = new Item("Dark chocolate", 50.00, 100);
			Item item11 = new Item("White chocolate", 50, 250);

			vendingMachineService.getInventory().addItem(item1, 20);
			vendingMachineService.getInventory().addItem(item2, 20);
			vendingMachineService.getInventory().addItem(item3, 20);
			vendingMachineService.getInventory().addItem(item4, 20);
			vendingMachineService.getInventory().addItem(item5, 20);
			vendingMachineService.getInventory().addItem(item6, 20);
			vendingMachineService.getInventory().addItem(item7, 20);
			vendingMachineService.getInventory().addItem(item8, 20);
			vendingMachineService.getInventory().addItem(item9, 20);
			vendingMachineService.getInventory().addItem(item10, 20);
			vendingMachineService.getInventory().addItem(item11, 20);

		}

		else if (maintenanceChoice == 2) {
			System.out.print("How many products you want to add? (Minimum of 8 products)");
			int nProducts = scanner.nextInt();

			if (nProducts < 8) {
				System.out.println("Minimum of 8 products! ");
			} else if (nProducts > 20) {
				System.out.println("That exceeds the limit of slots! ");
			}

			for (int i = 0; i < nProducts; i++) {
				System.out.print("Product name: ");
				String name = scanner.nextLine();
				scanner.nextLine();
				System.out.print("Price: ");
				double price = scanner.nextDouble();
				System.out.print("Calories: ");
				double calories = scanner.nextDouble();
				Item item = new Item(name, price, calories);

				System.out.print("Quantity: ");
				int quantity = scanner.nextInt();
				vendingMachineService.getInventory().addItem(item, quantity);
			}
		}

		while (maintenanceChoice == 3) {
			System.out.println("Restocking: ");
			ArrayList<String> finalInventory = this.vendingMachineService.getInventory().getUniqueItemNames();

			for (String item : finalInventory) {
				System.out.println("Inventory: ");
				System.out.printf("x%d %s", vendingMachineService.getInventory().getQuantity(item), item);

			}

			System.out.print("Which product do you want to restock? ");
			String itemName = scanner.nextLine();
			scanner.next();
			Item item = this.vendingMachineService.getInventory().findFirst(itemName);

			System.out.print("Quantity: ");
			int quantity = scanner.nextInt();

			this.vendingMachineService.getInventory().addItem(item, quantity);

			System.out.print("Do you want to add more quantity (Yes/No)? ");
			String choice = scanner.nextLine();
			scanner.next();

			if (choice.toUpperCase() != "YES") {
				maintenanceChoice = 0;
			}

		}

	}

		private void useVendingMachineAsCustomer() {
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Add to Cart\n2. Pay and Checkout\n3. Clear Cart\n4.Abort");

			while (this.choice == 11) {

				int userChoice = sc.nextInt();

				if (userChoice == 1) {
					this.choice = 12;
					this.addToCartMenu();
				} else if (userChoice == 2) {
					this.choice = 13;
					this.givePaymentAndCheckout();
				} else if (userChoice == 3) {
					this.vendingMachineService.clearCart();
					continue;
				} else if (userChoice == 4) {
					this.choice = -1;
					this.start();
				} else {
					System.out.println("Wrong input!");

				}
			}

		}

		private void addToCartMenu () {


			System.out.println("List of products:");
			for (var products : this.vendingMachineService.getInventory().getUniqueItemNames()) {
				System.out.println("- " + products);
			}
			System.out.println("-----------------------------");
			System.out.println("What would you like to buy? (return 'DONE' once finished adding to cart)");

			while (this.choice == 12) {
				Scanner sc = new Scanner(System.in);
				String desiredItem = sc.nextLine();
				System.out.println("How many?");
				int quantity = sc.nextInt();
				if (this.vendingMachineService.getInventory().getUniqueItemNames().contains(desiredItem)) {
					try {
						this.vendingMachineService.addToCart(desiredItem, quantity);
					} catch (Exception e) {
						System.out.println("Not enough in stock!");
					}
					continue;
				} else {
					if (desiredItem != "DONE") {
						System.out.println("Wrong input!");
					}
					sc.close();
					this.choice = 11;
				}
			}
			System.out.println("Total cost in cart: " + String.valueOf(this.vendingMachineService.getTotalCostInCart()));
			this.useVendingMachineAsCustomer();
		}

		private void givePaymentAndCheckout () {
			ArrayList<Denomination> thePayment = new ArrayList<>();
			ArrayList<Denomination> change = new ArrayList<>();

			while (this.choice == 13) {
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter denominations: 1, 5, 10, 20, 50, 100, 200, 500, 1000. Input 'DONE' if done.");
				String input = sc.nextLine();

				if (input.equals("DONE")) {
					sc.close();
					change = this.vendingMachineService.payForCart(thePayment);

					System.out.println("-----------------------------------------------------");
					System.out.println("Items bought:");
					for (var itemsInCart : vendingMachineService.getCart()) {
						System.out.println("- " + itemsInCart.getName());
					}
					System.out.println("Total cost: " + String.valueOf(this.vendingMachineService.getTotalCostInCart()));
					System.out.println("Change: ");
					for (var d : change) {
						System.out.print(d.name() + " ");
					}
					this.vendingMachineService.clearCart();
					System.out.println("-----------------------------------------------------");
					this.choice = 11;
				}

				double moneyIn = Double.valueOf(input);
				try {
					thePayment.add(Denomination.of(moneyIn));
					continue;
				} catch (Exception e) {
					System.out.println("Invalid input!");
					continue;
				}
			}

		}

	}