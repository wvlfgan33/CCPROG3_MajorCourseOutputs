import java.util.Scanner;

public class VendingMachine {
    private VendingMachineService vendingMachineService;
	private int choice = -1;
	/*
		Scene -1: Starting screen
		
		Scene 1: Start up Vending Machine
			Scene 11: Using vending machine as a customer
			Scene 12: Adding items to cart
			Scene 13: Giving payment
			
		Scene 2: Vending Machine management/setup -- Admin things
		
		Scene 3: Terminate Program
		
		
	*/
	
    public void start(){
		this.vendingMachineService = new VendingMachineService();
        Scanner scanner = new Scanner(System.in);

        while (choice == -1){
            System.out.println("CCPROG3 Vending Machine");
            System.out.println("Menu: ");
            System.out.println("1. Start Up Vending Machine.\n2. Test/Manage/Setup a Vending Machine\n3. Exit");
            choice = scanner.nextInt();
			scanner.close();
            if (choice == 1){
                this.startUpVendingMachine();
            } else if (choice == 2){
                this.testVendingMachine();
			} else if (choice == 3){

                //scanner.close();
            } else {
                System.out.println("Wrong input!");
            }



        }
    }
    private void startUpVendingMachine(){
		while (this.choice == 1) {
			try {
				this.vendingMachineService.begin();
				this.choice = 11;
			} catch (Exception e) {
				System.out.println("Failed to start Vending Machine!")
				System.out.println(e);
				this.choice = -1;
				this.start();
			}
		}
	 
    }
	
	private void useVendingMachineAsCustomer() {
		Scanner sc = new Scanner(System.in);
		while (this.choice == 11) {
			System.out.println("-----------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Add to Cart\n2. Pay and Checkout\n3. Clear Cart\n4.Abort");
			
			int userChoice = sc.nextInt();
			scanner.close();
			if (userChoice == 1) {
				this.choice = 12;
				this.addToCartMenu();
			} else if (userChoice == 2) {
				this.choice = 13;
				this.paymentAndCheckout();
			} else if (userChoice == 3) {
				this.vendingMachineService.clearCart();
				continue;
			} else {
				if (userChoice != 4) { 
					System.out.println("Wrong input!");
				}
				this.choice = -1;
				this.start();
			}
		}
		
	}

	private void addToCartMenu() {
		
	
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

	private void givePaymentAndCheckout() {
		ArrayList<Denomination> thePayment = new ArrayList<>();
		ArrayList<Denomination> change = new ArrayList<>();
		
		while (this.choice == 13) {
			Scanner sc = new Scanner(System.in);
			
			System.println("Enter denominations: 1, 5, 10, 20, 50, 100, 200, 500, 1000. Input 'DONE' if done.");
			String input = sc.nextString();
			
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
				this.choice == 11;
			}
			
			double moneyIn = Double.valueOf(input);
			try {
				thePayment.add(Denomination.of(moneyIn))
				continue;
			} catch (Exception e) {
				System.out.println("Invalid input!");
				continue;
			}
		}
		
	}


    private void testVendingMachine(){
		//while (choice == 2) {
			
		//}

    }

}
