package model;

import java.util.ArrayList;
import java.util.Collections;



public class CashRegister {
	private ArrayList<Denomination> cashList = new ArrayList<>();

	public void addCash(Denomination type, int copies){
		for (int i = 0 ; i < copies; i++){
			cashList.add(type);
		}
	}

	public ArrayList<Denomination> getCashList(){
		return cashList;
	}

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
}