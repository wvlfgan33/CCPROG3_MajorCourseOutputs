package javaswing;

import model.Denomination;
import model.RegularVendingMachineService;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PayAndCheckoutView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel denominationLabel;
    private JComboBox<String> denomination;
    private JLabel quantityLabel;
    private JSpinner quantity;
    private JButton makePaymentButton;

    private ArrayList<Denomination> payment = new ArrayList<Denomination>();

    private RegularVendingMachineView view;
    private RegularVendingMachineService vendingMachineService;

    public PayAndCheckoutView(RegularVendingMachineView view) {
        this.view = view;
        this.vendingMachineService = view.getVendingMachineService();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(800, 200);

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

        makePaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPay();
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
        try {
            Denomination billToBeInserted;
            double denominationValue = Double.parseDouble(denomination.getSelectedItem().toString());


            billToBeInserted = Denomination.of(denominationValue);
            int productQuantity = (int) quantity.getValue();
            //this.vendingMachineService.getCashRegister().addCash(billToBeInserted, productQuantity);

            for (int i = 0; i < productQuantity; i++) {
                this.payment.add(billToBeInserted);
            }

            JOptionPane.showMessageDialog(this, "Bills added to Payment! ", "", JOptionPane.INFORMATION_MESSAGE);



        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please provide valid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onPay() {
        try {
            ArrayList<Denomination> change = this.vendingMachineService.payForCart(this.payment);
            //this.vendingMachineService.clearCart();

            String msg = "Items Bought:";
            for (var itemsInCart : this.vendingMachineService.getCart()) {
                msg += "\n- " + itemsInCart.getName();
            }
            msg += "\n\nTotal cost: " + String.valueOf(this.vendingMachineService.getTotalCostInCart());
            msg += "\nChange:";

            for (var d : change) {
                msg += d.name() + " ";
            }
            this.payment = new ArrayList<Denomination>();
            this.vendingMachineService.clearCart();
            JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        this.payment = new ArrayList<Denomination>();
        dispose();
    }
}