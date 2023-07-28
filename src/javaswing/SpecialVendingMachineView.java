package javaswing;

import model.Item;
import model.SpecialRegularVendingMachineService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialVendingMachineView extends RegularVendingMachineView{

    public SpecialVendingMachineView(MainFrame frame) {
        super(frame);
        setTitle("Special Vending Machine");

        super.addProductButton.setEnabled(false);
        buyCustomCoffeeButton.setEnabled(false);

    }

    @Override
    protected void initService(){
        this.vendingMachineService = new SpecialRegularVendingMachineService();
    }

    @Override
    protected void prepopulateProductsButton() {
        super.prepopulateProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Regular items
                Item item1 = new Item("Coke", 20.00, 139.0);
                Item item2 = new Item("Pepsi", 20.00, 139.0);
                Item item3 = new Item("St. Miguel Beer", 40.00, 43.5);
                Item item4 = new Item("St. Joseph Beer", 45.00, 43.0);
                Item item5 = new Item("Cheetos", 69.00, 160.0);
                Item item6 = new Item("Cheddar Pringles", 80.00, 140.0);
                Item item7 = new Item("Bottled Water", 15.00, 0.0);
                Item item8 = new Item("Coffee", 100.00, 207);

                // Special items

                // Beans
                Item item9 = new Item("Arabica", 30.00,33.0,false,false);
                Item item10 = new Item("Robusta", 30.00,33.0,false,false);
                Item item11 = new Item("Excelsa", 30.00,33.0,false,false);
                Item item12 = new Item("Liberica", 30.00, 35.0, false, false);

                // Sugar
                Item item13 = new Item("Sugar Packet", 5, 5, false, true);

                // Misc
                Item itemMisc1 = new Item("Creamer", 5.00, 5.0, false, true);
                Item itemMisc2 = new Item("Dark chocolate", 50.00, 100.0, true, true);
                Item itemMisc3 = new Item("White chocolate", 50.00, 250.0, true, true);
                Item itemMisc4 = new Item("Chocolate Syrup", 20.00, 279.0, false, true);
                Item itemMisc5 = new Item("Vanilla Ice Cream", 20.00, 20.0, true, true);
                Item itemMisc6 = new Item("Caramel", 10.00, 10.0, false, true);
                Item itemMisc7 = new Item("Whipped Cream", 5.00, 5.0, false, true);
                Item itemMisc8 = new Item("Sprinkles", 5.00, 5.0, false, true);


                vendingMachineService.getInventory().addItem(item1, 10);
                vendingMachineService.getInventory().addItem(item2, 10);
                vendingMachineService.getInventory().addItem(item3, 10);
                vendingMachineService.getInventory().addItem(item4, 10);
                vendingMachineService.getInventory().addItem(item5, 10);
                vendingMachineService.getInventory().addItem(item6, 10);
                vendingMachineService.getInventory().addItem(item7, 10);
                vendingMachineService.getInventory().addItem(item8, 10);
                vendingMachineService.getInventory().addItem(item9, 10);
                vendingMachineService.getInventory().addItem(item10, 10);
                vendingMachineService.getInventory().addItem(item11, 10);
                vendingMachineService.getInventory().addItem(item12, 10);
                vendingMachineService.getInventory().addItem(item13, 10);
                vendingMachineService.getInventory().addItem(itemMisc1, 10);
                vendingMachineService.getInventory().addItem(itemMisc2, 10);
                vendingMachineService.getInventory().addItem(itemMisc3, 10);
                vendingMachineService.getInventory().addItem(itemMisc4, 10);
                vendingMachineService.getInventory().addItem(itemMisc5, 10);
                vendingMachineService.getInventory().addItem(itemMisc6, 10);
                vendingMachineService.getInventory().addItem(itemMisc7, 10);
                vendingMachineService.getInventory().addItem(itemMisc8, 10);


                JOptionPane.showMessageDialog(SpecialVendingMachineView.this, "Success! ", "", JOptionPane.INFORMATION_MESSAGE);
                drawInventory();
            }
        });
    }

    @Override
    protected void openToPublicButton(){
        openToPublicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vendingMachineService.begin();
                    addToCartButton.setEnabled(true);
                    payAndCheckoutButton.setEnabled(true);
                    viewCartButton.setEnabled(true);
                    clearCartButton.setEnabled(true);
                    buyCustomCoffeeButton.setEnabled(true);
                    JOptionPane.showMessageDialog(SpecialVendingMachineView.this, "Machine is now operational. ", "", JOptionPane.INFORMATION_MESSAGE);


                } catch (Exception d){
                    JOptionPane.showMessageDialog(SpecialVendingMachineView.this, "Machine is not yet operational. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }
}
