package javaswing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceFeaturesView extends JFrame{
    private JPanel MaintenanceFeaturesPanel;
    private JButton stockRestockItemsOrButton;
    private JButton addReplenishCollectMoneyButton;
    private JButton backButton;

    MaintenanceFeaturesView(RegularVendingMachineView regularVendingMachineView){
        setContentPane(MaintenanceFeaturesPanel);
        setTitle("Maintenance Features");
        setSize(450, 300);
        setVisible(true);


        stockRestockItemsOrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageItemsView(MaintenanceFeaturesView.this);
                MaintenanceFeaturesView.this.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularVendingMachineView.setVisible(true);
                MaintenanceFeaturesView.this.setVisible(false);
            }
        });
    }
}
