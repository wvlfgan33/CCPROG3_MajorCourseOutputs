package javaswing;

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
    private JTable InventoryTable;
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

        // TODO Remus 1.
        prepopulateProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // TODO Remus 2.
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // TODO Remus 3.
        addQuantityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Maintenance Features
    }

}
