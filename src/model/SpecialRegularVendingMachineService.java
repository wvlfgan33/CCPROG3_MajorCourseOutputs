package model;

/**
 * A model.SpecialVendingMachineService's difference to a RegularVendingMachine is that it has a customizability feature.
 * It includes cash register, summary, and inventory, if it is operational, and cart (list of items), as components of a model.SpecialVendingMachineService, in order.
 */
public class SpecialRegularVendingMachineService extends RegularVendingMachineService {
    @Override
    public void addToCart(String name, int quantity) {

        Item item = super.inventory.findFirst(name);
        SpecialItem si = (SpecialItem) item;

        if (si.getType() < 4){
            for (var x : super.cart){
                SpecialItem y = (SpecialItem) x;
                if (y.getType() == si.getType()){
                    throw new IllegalArgumentException("You can't have another type of this. ");
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
}

