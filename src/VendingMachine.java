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
		System.out.println("[CCPROG3 Vending Machine]");

		while (choice != 3) {

			System.out.println("Menu: ");
			System.out.println("1. Create a Vending Machine.\n2. Test/Manage/Setup a Vending Machine\n3. Exit");
			System.out.print(">> ");

			choice = scanner.nextInt();
			switch(choice){
				case 1:
					this.choice = 1;
					this.vendingMachineService = new VendingMachineService();
					break;

				case 2:
					this.choice = 2;
					this.testVendingMachine();
					break;

				case 3:
					scanner.close();
					break;

				default:
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

		int choice = -1;
		while (this.choice == 2 && choice != 3){
			System.out.println("Test the vending machine: ");
			System.out.println("1. Test the vending features.\n2. Test the maintenance features.\n3. Exit");
			System.out.print(">> ");
			choice = scanner.nextInt();

			switch (choice){
				case 1:
					//testvendingmachine features
					this.choice = 11;
					useVendingMachineAsCustomer();
					break;
				case 2:
					//testmaintenance features
					useVendingMachineAsModerator();
					break;
				case 3:
					//Exit
					break;
				default:
					System.out.println("Wrong input! ");
			}
		}

	}



		private void useVendingMachineAsCustomer() {
			//Scanner sc = new Scanner(System.in);
			for (var products : this.vendingMachineService.getInventory().getUniqueItemNames()) {
				System.out.println("- " + products);
			}
			System.out.println("-----------------------------");

			System.out.println("What would you like to do?");
			System.out.println("1. Add to Cart\n2. Pay and Checkout\n3. Clear Cart\n4.Abort");

			while (this.choice == 11) {

				int userChoice = scanner.nextInt();
				
				switch (userChoice) {
					case 1:
						this.choice = 12;
						this.addToCartMenu();
						break;

					case 2:
						this.choice = 13;
						this.givePaymentAndCheckout();
						break;

					case 3:
						this.vendingMachineService.clearCart();
						break;

					case 4:
						this.choice = 2;
						this.testVendingMachine();
						break;

					default:
						System.out.println("Wrong input!");
						this.choice = 2;
						this.testVendingMachine();
						break;
				}
			}

		}

		private void useVendingMachineAsModerator(){
			int maintenanceChoice = -1;
			while (maintenanceChoice != 4){
				System.out.println("Test maintenance features of the vending machine: ");
				System.out.println("What would you like to do?");
				System.out.print("""
						1. Restock/stock items or setting price of each item type
						2. Replenish/add money in the Vending Machine or collect money
						3. Print summary of transactions
						4. Exit
						>> """);
				System.out.print(">> ");
				

				maintenanceChoice = scanner.nextInt();

				switch (maintenanceChoice){
					case 1:
						this.manageItems();
						break;

					case 2:
						this.manageMoney();

						break;
					case 3:
						this.printOperationSummary();
						break;
					case 4:
						break;

					default:
						System.out.println("Wrong input!");
				}
			}

		}
		private void manageItems() {
		int maintenanceChoice = -1;
		while (maintenanceChoice != 4){

			System.out.println("Manage items: ");
			System.out.println("1. Automatic products insertion\n2. Manual product insertion.\n3. Restock items\n4. View inventory");
			System.out.println("What would you like to do?");
			System.out.print(">> ");
			maintenanceChoice = scanner.nextInt();

			switch (maintenanceChoice){
				case 1:
					this.automaticProductsInsertion();
					break;

				case 2:
					this.manualProductInsertion();
					break;

				case 3:
					this.restockSpecificItems();
					break;

				case 4:
					this.viewInventory();
					break;

				case 5:

					break;

				default:
					System.out.println("Wrong input!");
			}
		}


	}
		private void viewInventory(){
		ArrayList<String> inventory = this.vendingMachineService.getInventory().getUniqueItemNames();
		System.out.println("==============================================================");
		for (String itemName: inventory){
			int quantity = this.vendingMachineService.getInventory().getQuantity(itemName);
			double price = this.vendingMachineService.getInventory().getPrice(itemName);
			double calories = this.vendingMachineService.getInventory().getCalories(itemName);
			System.out.printf("x%s %s | P %s | Calories: %s\n", quantity, itemName, price, calories);
		}
		System.out.println("==============================================================");
	}
		private void automaticProductsInsertion(){
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

		vendingMachineService.getInventory().addItem(item1, 5);
		vendingMachineService.getInventory().addItem(item2, 5);
		vendingMachineService.getInventory().addItem(item3, 5);
		vendingMachineService.getInventory().addItem(item4, 5);
		vendingMachineService.getInventory().addItem(item5, 5);
		vendingMachineService.getInventory().addItem(item6, 5);
		vendingMachineService.getInventory().addItem(item7, 5);
		vendingMachineService.getInventory().addItem(item8, 5);
		vendingMachineService.getInventory().addItem(item9, 5);
		vendingMachineService.getInventory().addItem(item10, 5);
		vendingMachineService.getInventory().addItem(item11, 5);

	}

		private void manualProductInsertion(){
		System.out.print("How many products you want to add? (Minimum of 8 products): ");
		System.out.print(">> ");
		int nProducts = scanner.nextInt();

		for (int i = 0; i < nProducts; i++) {
			System.out.print("Product name: ");

			scanner.nextLine();
			String name = scanner.nextLine();

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

		private void restockSpecificItems(){
		int maintenanceChoice = -1;
		while (maintenanceChoice != 3){
			System.out.println("Restocking: ");
			viewInventory();

			System.out.print("Which product do you want to restock? ");
			System.out.print(">> ");
			scanner.nextLine();
			String itemName = scanner.nextLine();
			Item item = this.vendingMachineService.getInventory().findFirst(itemName);

			System.out.print("Quantity: ");
			int quantity = scanner.nextInt();

			this.vendingMachineService.getInventory().addItem(item, quantity);

			System.out.print("Do you want to add more quantity (Yes/No)? ");
			System.out.print(">> ");
			scanner.nextLine();
			String choice = scanner.nextLine();
			scanner.next();

			if (choice.toUpperCase() != "YES") {
				maintenanceChoice = 3;
			}
		}

	}

		private void addToCartMenu () {


			System.out.println("List of products:");
			
			System.out.println("What would you like to buy? (return 'DONE' once finished adding to cart)");

			while (this.choice == 12) {
				
				//scanner.nextLine();
				String desiredItem = scanner.next();
				
				
				System.out.println("How many?");
				int quantity = scanner.nextInt();
				
				
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

				System.out.println("Enter denominations: 1, 5, 10, 20, 50, 100, 200, 500, 1000. Input 'DONE' if done.");
				System.out.print(">> ");
				scanner.nextLine();
				String input = scanner.nextLine();

				if (input.toUpperCase().equals("DONE")) {
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
					this.useVendingMachineAsCustomer();
				}
				try {
				double moneyIn = Double.valueOf(input);
					thePayment.add(Denomination.of(moneyIn));
					continue;
				} catch (Exception e) {
					System.out.println("Invalid input!");
					continue;
				}
			}
		
		}

		private void manageMoney(){
			int maintenanceChoice = -1;
			while (maintenanceChoice != 4){
				System.out.println("Manage money: ");
				System.out.println("1. Automatic replenishment of cash supply\n2. Manual replenishment of cash supply.\n3. Collect all money.\n4. Exit");
				System.out.println("What would you like to do?");
				maintenanceChoice = scanner.nextInt();

				switch (maintenanceChoice){
					case 1:
						this.replenishCashSupply();
						break;

					case 2:
						this.addCashToSupplyManually();
						break;

					case 3:
						this.vendingMachineService.getCashRegister().collectAllCash();
						break;

					case 4:
						break;

					default:
						System.out.println("Wrong input!");
				}
			}
		}
		
		private void replenishCashSupply() { //or you can have this set the number of each denomination to be some number.
			int addition = 15;
			ArrayList<Denomination> cashListToBeReplenished = this.vendingMachineService.getCashRegister().getCashList();
			for (Denomination de : Denomination.values()) {
				for (int i = 0; i < addition; i++) {
					cashListToBeReplenished.add(de);
				}
			}
			this.vendingMachineService.getCashRegister().setCashList(cashListToBeReplenished);
		}


	private void addCashToSupplyManually() {

			Denomination billToBeInserted = null;
			int maintenanceChoice = -1;
			while (maintenanceChoice != 2) {
				System.out.println("Enter denominations: 1, 5, 10, 20, 50, 100, 200, 500, 1000. Input '3' if done.");
				double denomInput = scanner.nextDouble();
				
				if (denomInput == 3) {
					maintenanceChoice = 2;
					break;
				}
				
				System.out.print("Quantity: ");
				int quantity = scanner.nextInt();

				try {
					billToBeInserted = Denomination.of(denomInput);
					addCashToSupply(billToBeInserted, quantity);
				} catch (Exception e){
					System.out.println("Invalid input!");
					continue;
				}
				System.out.println("Do you want to add more (Yes/No)? ");
				scanner.nextLine();
				String choice = scanner.nextLine();
				scanner.next();

				if (choice.toUpperCase().equals("YES")){
					maintenanceChoice = 2;
				}

			}
		}
		private void addCashToSupply(Denomination denom, int quantity) {
				ArrayList<Denomination> cashListToBeAdded = this.vendingMachineService.getCashRegister().getCashList();
				for (int i = 0; i < quantity; i++) {
					cashListToBeAdded.add(denom);
				}
				this.vendingMachineService.getCashRegister().setCashList(cashListToBeAdded);
			}
		
		private void printOperationSummary() {
			for (String item : vendingMachineService.getSummary().getUniqueItemNamesInSales()) {
				System.out.println(item + " x" + vendingMachineService.getSummary().getQuantitySold(item));
			}
			System.out.println("Total Earnings: Php " + this.vendingMachineService.getSummary().computeTotalEarnings());
			
			System.out.println("===============================================");
			System.out.println("Starting Inventory:\n");
			for (Item item : this.vendingMachineService.getSummary().getInitialInventory()) {
				System.out.println(item.getName());
			}
			System.out.println("Current Inventory:\n");
			this.viewInventory();
		}

	}
