/**
 * A VendingMachineService acts as a bridge
 */

import model.Denomination;
import model.Inventory;
import model.Item;
import model.CashRegister;
import model.Summary;

import java.util.ArrayList;

public class VendingMachineService {

	private CashRegister cashRegister;
	private Summary summary;
	private Inventory inventory;
	private boolean isOperational = false;
	private ArrayList<Item> cart = new ArrayList<>();



	public VendingMachineService() {
		this.inventory = new Inventory();
		this.cashRegister = new CashRegister();
		this.summary = new Summary(this.inventory);
		this.cart = new ArrayList<>();

	}

	public void begin(){

		if (this.inventory.getUniqueItemCount() <= 8){
			throw new IllegalArgumentException("The minimum slots is not satisfied.");
		}

		for (String itemName: this.inventory.getUniqueItemNames()){
			if (this.inventory.getQuantity(itemName) < 10){
				throw new IllegalArgumentException("The minimum quantity per item requirement is not satisfied.");
			}
		}

		
		if (!this.isOperational) {
			this.summary.setInitialInventory(this.inventory.getInStock());
		} 
		
		this.isOperational = true;
	}

	public boolean getIsOperational(){ return this.isOperational; }

	public Inventory getInventory(){ return this.inventory; }
	public CashRegister getCashRegister(){ return this.cashRegister; }

	public Summary getSummary(){ return this.summary; }

	public void addToCart(String name, int quantity){
		Item item = this.inventory.findFirst(name);

		if (quantity > this.inventory.getQuantity(name)){
			throw new IllegalArgumentException("Not enough quantity for the requested item");
		}
		for (int i = 0; i < quantity; i++){
			this.cart.add(item);
		}
	}
	public ArrayList<Item> getCart(){ return this.cart; }

	public void clearCart(){
		this.cart = new ArrayList<>();
	}

	public double getTotalCostInCart(){
		double total = 0;
		for (int i = 0; i < this.cart.size(); i++){
			total += this.cart.get(i).getPrice();
		}
		return total;
	}


	public ArrayList<Denomination> payForCart(ArrayList<Denomination> payment){

		ArrayList<Item> cart = this.getCart();
		double priceOfCart = this.getTotalCostInCart();
		ArrayList<Denomination> changeList = this.cashRegister.transact(payment, priceOfCart);
		
		for (int i = 0; i < this.getCart().size(); i++){
			this.inventory.dispenseItem(this.getCart().get(i).getName());
		}
		
		this.summary.recordSales(cart);
		
		return changeList;
	}

}


