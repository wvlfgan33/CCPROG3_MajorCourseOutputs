package javaswing;

import model.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageItemsView extends JFrame {


    private JButton automaticProductsInsertionButton;
    private JButton manualProductInsertionButton;
    private JButton restockSpecificItemSButton;
    private JButton backButton;
    private JPanel ManageItemsPanel;

    ManageItemsView(MaintenanceFeaturesView maintenanceFeaturesView){
        setContentPane(ManageItemsPanel);
        setTitle("Manage Items");
        setSize(450, 300);
        setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maintenanceFeaturesView.setVisible(true);
                ManageItemsView.this.setVisible(false);
            }
        });

        automaticProductsInsertionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item1 = new Item("Coke", 20.00, 139);
                Item item2 = new Item("Pepsi", 20.00, 139);
                Item item3 = new Item("St. Miguel Beer", 40.00, 43);
                Item item4 = new Item("St. Joseph Beer", 45.00, 43);
                Item item5 = new Item("Cheetos", 69.00, 160);
                Item item6 = new Item("Cheddar Pringles", 80.00, 140);
                Item item7 = new Item("Bottled Water", 15.00, 0);
                Item item8 = new Item("Coffee", 100.00, 207);
                Item item9 = new Item("Chocolate Syrup", 20.00, 279);
                Item item10 = new Item("Dark chocolate", 50.00, 100);
                Item item11 = new Item("White chocolate", 50, 250);


            }
        });
    }


}
