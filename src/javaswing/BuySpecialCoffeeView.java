package javaswing;

import model.SpecialRegularVendingMachineService;

import javax.swing.*;
import java.awt.event.*;

public class BuySpecialCoffeeView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox beansbox;
    private JComboBox addon1;
    private JComboBox addon3;
    private JComboBox addon2;
    private JComboBox roastbox;
    private JComboBox sugarbox;

    private SpecialVendingMachineView view;
    private SpecialRegularVendingMachineService vendingMachineService;

    public BuySpecialCoffeeView(SpecialVendingMachineView view) {
        this.view = view;
        this.vendingMachineService = view.getSpecialVendingMachineService();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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

        String beans;
        String roast;
        String sugarLevel;
        String addOn1;
        String addOn2;
        String addOn3;

        beans = (String) beansbox.getSelectedItem();
        roast = (String) roastbox.getSelectedItem();

        if (!((String) sugarbox.getSelectedItem()).equals("0% Sugar")) {
            sugarLevel = (String) sugarbox.getSelectedItem();
            vendingMachineService.addToCart(sugarLevel, 1);
        }
        addOn1 = (String) addon1.getSelectedItem();
        addOn2 = (String) addon2.getSelectedItem();
        addOn3 = (String) addon3.getSelectedItem();

        vendingMachineService.addToCart(beans, 1);
        //vendingMachineService.addToCart(roast, 1);
        //vendingMachineService.addToCart(sugarLevel, 1);
        vendingMachineService.addToCart(addOn1, 1);
        vendingMachineService.addToCart(addOn2, 1);
        vendingMachineService.addToCart(addOn3, 1);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
