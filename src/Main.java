import model.Item;

public class Main{
    public static void main(String[] args){

        // model.Item definition
        Item item1 = new Item("Coke", 20.00, 139);
        Item item2 = new Item("Pepsi", 20.00, 139);
        Item item3 = new Item("St. Miguel Beer",40.00,43);
        Item item4 = new Item("St. Joseph Beer",45.00, 43);
        Item item5 = new Item("Cheetos King Size", 69.00,160);
        Item item6 = new Item("Cheddar Pringles", 80.00,140);
        Item item7 = new Item("Bottled Water", 15.00, 0);

        Item item8 = new Item("Standard Gelato", 100.00,207);
        Item item9 = new Item("Chocolate Syrup", 20.00,279);


        // Vending Machine

        VendingMachine m = new VendingMachine();
//        m.addItem(item1);
        m.setItem(item2,3);
        m.setItem(item2, 17);
//        m.addItem(item3,9);
//        m.addItem(item4, 21);
//        m.addItem(item5);
//        m.addItem(item6);
//        m.addItem(item7);
//        m.addItem(item8);
//        m.addItem(item9);

//        m.printInventory();
    }
}