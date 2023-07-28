package javaswing;

import model.RegularVendingMachineService;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TransactionsSummary extends JFrame{
    private JPanel transactionSummaryPanel;
    private JList listOfSoldItems;
    private JTable initialInventoryTable;
    private JTable currentInventoryTable;
    private JPanel itemsSoldLabel;
    private JPanel initialInventoryLabel;
    private JLabel currentInventoryLabel;
    private RegularVendingMachineService vendingMachineService;
    private RegularVendingMachineView view;

    public TransactionsSummary(RegularVendingMachineView view){
        this.vendingMachineService = view.getVendingMachineService();
        this.view = view;

        setContentPane(transactionSummaryPanel);
        setTitle("Transaction Summary Report");
        setSize(1000, 600);
        setVisible(true);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                view.setVisible(true);
            }
        });

    }
}
