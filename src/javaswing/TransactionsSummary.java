package javaswing;

import model.RegularVendingMachineService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class TransactionsSummary extends JFrame {
    private JPanel transactionSummaryPanel;
    private JList listOfSoldItems;
    private JTable initialInventoryTable;
    private JTable currentInventoryTable;
    private JPanel itemsSoldPanel;
    private JPanel rightPanel;
    private JScrollPane scrollPane;
    private JLabel totalEarnings;
    private JPanel currentInventoryPanel;
    private JPanel initialInventoryPanel;
    private JScrollPane initialInventoryPane;
    private JScrollPane currentInventoryPane;
    private JTable itemsSoldTable;

    private RegularVendingMachineService vendingMachineService;
    private RegularVendingMachineView view;

    public TransactionsSummary(RegularVendingMachineView view) {
        this.initInitInventoryTable();
        this.initCurrInventoryTable();
        this.initListOfSoldItemsTable();

        this.vendingMachineService = view.getVendingMachineService();
        this.view = view;

        setContentPane(transactionSummaryPanel);
        setTitle("Transaction Summary Report");
        setSize(1000, 600);
        setVisible(true);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.setVisible(true);
            }
        });


        // List of sold items
        this.drawListOfSoldItems();

        // Initial inventory table
        this.drawInitInventory();

        // Current inventory table
        this.drawCurrInventory();

        // Total earnings
//        this.calculateTotalEarnings();


    }

    private void initInitInventoryTable() {
        Vector<String> headers = new Vector<>();
        headers.add("Name");
        headers.add("Price");
        headers.add("Calories");
        headers.add("Quantity");

        DefaultTableModel tableContents = new DefaultTableModel(headers, 0);
        this.initialInventoryTable.setModel(tableContents);

        this.initialInventoryPane.setViewportView(this.initialInventoryTable);
    }

    private void initCurrInventoryTable() {
        Vector<String> headers = new Vector<>();
        headers.add("Name");
        headers.add("Price");
        headers.add("Calories");
        headers.add("Quantity");

        DefaultTableModel tableContents = new DefaultTableModel(headers, 0);
        this.currentInventoryTable.setModel(tableContents);

        this.currentInventoryPane.setViewportView(this.currentInventoryTable);
    }

    private void initListOfSoldItemsTable() {
        Vector<String> header = new Vector<>();

        header.add("Name");
//        listContents.addElement("Wow");
//        listContents.addElement("Wow");
//        listContents.addElement("Wow");
//        listContents.addElement("Wow");
//        listContents.addElement("Wow");

        DefaultTableModel tableContents = new DefaultTableModel(header, 0);
        this.itemsSoldTable.setModel(tableContents);

        this.scrollPane.setViewportView(this.itemsSoldTable);
    }

    private void drawListOfSoldItems(){

        ArrayList<String> soldItems = this.vendingMachineService.getSummary().getUniqueItemNamesInSales();
        DefaultTableModel tableContents = (DefaultTableModel) this.initialInventoryTable.getModel();
        tableContents.setRowCount(0);

        for (String item : soldItems){
            tableContents.addRow(new Object[] {
                    item
            });
        }

        itemsSoldTable.repaint();
    }



    private void drawInitInventory() {
        ArrayList<String> uniqueItemNames = this.vendingMachineService.getInventory().getUniqueItemNames();
        DefaultTableModel tableContents = (DefaultTableModel) this.initialInventoryTable.getModel();
        tableContents.setRowCount(0);

        for (String itemName : uniqueItemNames) {
            double price = this.vendingMachineService.getInventory().getPrice(itemName);
            double calories = this.vendingMachineService.getInventory().getCalories(itemName);
            int quantity = this.vendingMachineService.getSummary().countItemInInitialInventory(itemName);

            tableContents.addRow(new Object[] {
                    itemName, price, calories, quantity
            });
        }

        initialInventoryTable.repaint();
    }

    protected void drawCurrInventory(){
        ArrayList<String> uniqueItemNames = this.vendingMachineService.getInventory().getUniqueItemNames();

        DefaultTableModel tableContents = (DefaultTableModel) this.currentInventoryTable.getModel();
        tableContents.setRowCount(0);

        for (String itemName : uniqueItemNames){
            double price = this.vendingMachineService.getInventory().getPrice(itemName);
            double calories = this.vendingMachineService.getInventory().getCalories(itemName);
            int quantity = this.vendingMachineService.getInventory().getQuantity(itemName);

            tableContents.addRow(new Object[] {
                    itemName, price, calories, quantity
            });
        }

        currentInventoryTable.repaint();
    }

    private void calculateTotalEarnings(){
        double sales = this.vendingMachineService.getSummary().computeTotalEarnings();
        totalEarnings.setText("Total earnings: " + sales);
    }
}
