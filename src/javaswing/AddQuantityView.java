package javaswing;

import model.Item;
import model.RegularVendingMachineService;

import javax.swing.*;
import java.awt.event.*;

public class AddQuantityView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField productName;
    private JSpinner quantity;
    private JLabel productNameLabel;
    private JLabel quantityLabel;
    private RegularVendingMachineService vendingMachineService;
    private RegularVendingMachineView view;

    public AddQuantityView(RegularVendingMachineView view) {
        this.vendingMachineService = view.getVendingMachineService();
        this.view = view;
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

        try{
            int productQuantity = (int) quantity.getValue();
            Item item = this.vendingMachineService.getInventory().findFirst(productName.getText());
            this.vendingMachineService.getInventory().addItem(item, productQuantity);
            JOptionPane.showMessageDialog(this, "Success! ", "", JOptionPane.INFORMATION_MESSAGE);
            view.drawInventory();
            dispose();


        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please provide valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
