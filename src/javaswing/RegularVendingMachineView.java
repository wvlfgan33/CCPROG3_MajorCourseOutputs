package javaswing;

import model.Denomination;
import model.Item;
import model.RegularVendingMachineService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegularVendingMachineView extends JFrame {
    private JPanel vendingMachinePanel;
    private JButton openVendingMachineToButton;
    private JButton maintenanceFeaturesButton;
    private JButton backButton;
    private JButton payAndCheckoutButton;
    private JButton clearCartButton;
    private JButton addToCartButton;
    private JButton addQuantityButton;
    private JButton collectAllMoneyButton;
    private JButton openToPublicButton;
    private JButton addProductButton;
    private JButton prepopulateProductsButton;
    private JButton addCashButton;
    private JButton prepopulateCashRegisterButton;
    private JTable table1;
    private JButton testVendingMachine;

    private RegularVendingMachineService regularVendingMachineService;

    public RegularVendingMachineService getRegularVendingMachineService() {
        return regularVendingMachineService;
    }

    public RegularVendingMachineView(MainFrame frame){
        setContentPane(vendingMachinePanel);
        setTitle("Regular Vending Machine");
        setSize(1000, 600);
        setVisible(true);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
            }
        });

        this.regularVendingMachineService = new RegularVendingMachineService();

        // Vending Features

        this.addToCartButton();

        this.payAndCheckoutButton();

        this.clearCartButton();

        // Maintenance Features
         // Manage Items

            // Prepopulate Products
        this.prepopulateProductsButton();

            // Add Product Manually
        this.addProductButton();

            // Add Quantity
        this.addQuantityButton();

         // Manage Money

            // Prepopulate Cash Register
        this.prepopulateCashRegisterButton();

            // Add Cash Manually
        this.addCashButton();

            // Collect All Money
        this.collectAllMoneyButton();

         // Others

            // Open to Public
        this.openToPublicButton();

    }

    // Vending Features

    // TODO Remus 1.
    protected void addToCartButton(){
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    // TODO Remus 2.
    protected void payAndCheckoutButton(){

        payAndCheckoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    // TODO Remus 3.
    protected void clearCartButton(){
        clearCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    // Maintenance Features

        // Manage Items
    protected void prepopulateProductsButton(){
        prepopulateProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item1 = new Item("Coke", 20.00, 139.0);
                Item item2 = new Item("Pepsi", 20.00, 139.0);
                Item item3 = new Item("St. Miguel Beer", 40.00, 43.5);
                Item item4 = new Item("St. Joseph Beer", 45.00, 43.0);
                Item item5 = new Item("Cheetos", 69.00, 160.0);
                Item item6 = new Item("Cheddar Pringles", 80.00, 140.0);
                Item item7 = new Item("Bottled Water", 15.00, 0.0);
                Item item8 = new Item("Coffee", 100.00, 207);
                Item item9 = new Item("Chocolate Syrup", 20.00, 279.0);
                Item item10 = new Item("Dark chocolate", 50.00, 100.0);
                Item item11 = new Item("White chocolate", 50.00, 250.0);

                regularVendingMachineService.getInventory().addItem(item1, 10);
                regularVendingMachineService.getInventory().addItem(item2, 10);
                regularVendingMachineService.getInventory().addItem(item3, 10);
                regularVendingMachineService.getInventory().addItem(item4, 10);
                regularVendingMachineService.getInventory().addItem(item5, 10);
                regularVendingMachineService.getInventory().addItem(item6, 10);
                regularVendingMachineService.getInventory().addItem(item7, 10);
                regularVendingMachineService.getInventory().addItem(item8, 10);
                regularVendingMachineService.getInventory().addItem(item9, 10);
                regularVendingMachineService.getInventory().addItem(item10, 10);
                regularVendingMachineService.getInventory().addItem(item11, 10);
                JOptionPane.showMessageDialog(RegularVendingMachineView.this, "Success! ", "", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }

    protected void addProductButton(){
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductView(regularVendingMachineService);

            }
        });
    }
    protected void addQuantityButton(){
        addQuantityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddQuantityView(regularVendingMachineService);
            }
        });
    }
   protected void prepopulateCashRegisterButton(){
       prepopulateCashRegisterButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int addition = 15;
               for (Denomination de : Denomination.values()){
                   regularVendingMachineService.getCashRegister().addCash(de, addition);
               }

               JOptionPane.showMessageDialog(RegularVendingMachineView.this, "Success! ", "", JOptionPane.INFORMATION_MESSAGE);
           }
       });
   }
   protected void addCashButton(){
       addCashButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new AddCashView(regularVendingMachineService);
           }
       });
   }
   protected void collectAllMoneyButton(){
       collectAllMoneyButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               double totalMoney = regularVendingMachineService.getCashRegister().collectAllCash();
               JOptionPane.showMessageDialog(RegularVendingMachineView.this, "Total Money Collected: " + totalMoney, "", JOptionPane.INFORMATION_MESSAGE);

           }
       });
   }
   protected void openToPublicButton(){
       openToPublicButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
                   regularVendingMachineService.begin();

                   addToCartButton.setEnabled(true);
                   payAndCheckoutButton.setEnabled(true);
                   clearCartButton.setEnabled(true);
                   JOptionPane.showMessageDialog(RegularVendingMachineView.this, "Machine is now operational. ", "", JOptionPane.INFORMATION_MESSAGE);


               } catch (Exception d){
                   JOptionPane.showMessageDialog(RegularVendingMachineView.this, "Machine is not yet operational. ", "Error", JOptionPane.ERROR_MESSAGE);
               }


           }
       });
   }



}
