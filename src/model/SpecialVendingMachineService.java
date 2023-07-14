package model;

import java.util.ArrayList;

public class SpecialVendingMachineService extends VendingMachineService{
    @Override
    public void addToCart(String name, int quantity) {

        Item item = super.inventory.findFirst(name);
        SpecialItem si = (SpecialItem) item;

        if (si.getType() < 4){
            for (var x : super.cart){
                SpecialItem y = (SpecialItem) x;
                if (y.getType() == si.getType()){
                    throw new IllegalArgumentException("You can't have");
                }
            }
        }


        if (quantity > super.inventory.getQuantity(name)){
            throw new IllegalArgumentException("Not enough quantity for the requested item");
        }
        for (int i = 0; i < quantity; i++){
            super.cart.add(si);
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

