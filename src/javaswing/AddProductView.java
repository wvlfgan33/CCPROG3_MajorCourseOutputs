package javaswing;

import model.Item;
import model.RegularVendingMachineService;

import javax.swing.*;
import java.awt.event.*;

public class AddProductView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField productName;
    private JLabel productNameLabel;
    private JTextField price;
    private JTextField calories;
    private JSpinner quantity;
    private JLabel priceLabel;
    private JLabel caloriesLabel;
    private JLabel quantityLabel;

    private RegularVendingMachineService regularVendingMachineService;

    public AddProductView(RegularVendingMachineService regularVendingMachineService) {
        this.regularVendingMachineService = regularVendingMachineService;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(800, 150);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setVisible(true);
    }

    private void onOK() {
        // add your code here
        try{
            double productPrice = Double.parseDouble(price.getText());
            double productCalories = Double.parseDouble(calories.getText());
            int productQuantity = (int) quantity.getValue();
            Item item = new Item(productName.getText(), productPrice, productCalories);
            this.regularVendingMachineService.getInventory().addItem(item, productQuantity);
            JOptionPane.showMessageDialog(this, "Success! ", "", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please provide valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }

//        System.out.println(productName.getText());
//        System.out.println(price.getText());
//        System.out.println(calories.getText());
//        System.out.println(quantity.getValue());

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
