/**
 * A CashRegister represents the usual cash register that is known in restaurants.
 * The difference is that this CashRegister is inside the VendingMachineService
 * for which it is responsible for all the transactions, namely adding cash, receiving payments,
 * dispensing change, and so on. It includes the list(cashList) of the cash(Denomination) in the CashRegister,
 * where all the denominations are stored.
 */

package model;
import java.util.ArrayList;
import java.util.Collections;


public class CashRegister {
	private ArrayList<Denomination> cashList = new ArrayList<>();

	/**
	 * adds denomination/s into the cash register, with the given denomination type, and the quantity of the
	 * denomination type
	 * @param type denomination type for the cash register
	 * @param copies quantity of the denomination type
	 */
	public void addCash(Denomination type, int copies){
		for (int i = 0 ; i < copies; i++){
			cashList.add(type);
		}
	}

	/**
	 * returns the cash list of the cash register
	 * @return the cash list of the cash register
	 */
	public ArrayList<Denomination> getCashList(){
		return cashList;
	}

	/**
	 * sets the cash list of the cash register
	 * @param newCashList new cash list to set to the cash register
	 */
	public void setCashList(ArrayList<Denomination> newCashList) {
		this.cashList = newCashList;
	}

	/**
	 * collects all cash from the register
	 */
	public void collectAllCash() {
		this.cashList = new ArrayList<>();
	}

	/**
	 * the user transacts with the cash register of the vending machine
	 * @param payment denominations of the user to be inserted in the vending machine
	 * @param priceOfItem the price of the item to be bought
	 * @return the list of change of the user in denominations
	 */
	public ArrayList<Denomination> transact(ArrayList<Denomination> payment, double priceOfItem){
		double totalPayment = 0;

		for (Denomination cash: payment){
			totalPayment += cash.getValue();
		}
		// if yung pinambayad ko mas maliit sa babayaran, di dapat pwede
		if (totalPayment < priceOfItem){
			throw new IllegalArgumentException("You are broke");
		}
		double totalChange = totalPayment - priceOfItem;
		ArrayList<Denomination> changeList = this.getChange(totalChange, payment);
		return changeList;
	}

	/**
	 * as the user transacts with the cash register of the vending machine, the method transact
	 * uses the getChange as a helper method where it returns the change of the user.
	 * @param totalChange the total change of the user
	 * @param payment the payment of the user in denominations
	 * @return the list of change of the user in denominations
	 */
	public ArrayList<Denomination> getChange(double totalChange, ArrayList<Denomination> payment){
		ArrayList<Denomination> temporaryCash = new ArrayList<>();
		temporaryCash.addAll(cashList);
		temporaryCash.addAll(payment);
		Collections.sort(temporaryCash);
		ArrayList<Denomination> changeList = new ArrayList<>();

		for (Denomination cash: temporaryCash){
			if (cash.getValue() <= totalChange){
				changeList.add(cash);
				totalChange -= cash.getValue();
			}
		}
		if (totalChange > 0){
			throw new IllegalArgumentException("Not enough change in the vending machine.");
		}
		cashList = temporaryCash;

		for (Denomination change: changeList){
			cashList.remove(change);
		}
		return changeList;
	}
}