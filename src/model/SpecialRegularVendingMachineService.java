package model;

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

