package model;

import java.util.ArrayList;

public class RegularVendingMachineService extends VendingMachineService{

    public RegularVendingMachineService(){
        super();
    }

    @Override
    public void addToCart(String name, int quantity) {

            Item item = super.inventory.findFirst(name);

            if (quantity > super.inventory.getQuantity(name)){
                throw new IllegalArgumentException("Not enough quantity for the requested item");
            }
            for (int i = 0; i < quantity; i++){
                super.cart.add(item);
        }
    }


    @Override
    public ArrayList<Denomination> payForCart(ArrayList<Denomination> denominations) {
        ArrayList<Item> cart1 = super.cart;
        double priceOfCart = super.getTotalCostInCart();
        ArrayList<Denomination> changeList = super.cashRegister.transact(denominations, priceOfCart);

        for (int i = 0; i < super.cart.size(); i++){
            super.getInventory().dispenseItem(super.cart.get(i).getName());
        }

        super.summary.recordSales(cart1);

        return changeList;
    }

}
