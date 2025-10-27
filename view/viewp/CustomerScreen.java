package view.viewp;

import javax.swing.*;
import java.awt.event.*;
import model.*;
import service.OrderService;
import exceptions.TaxiNotAvailableException;
import control.SystemDataBase;

public class CustomerScreen extends JFrame {
    private Customer customer;

    public CustomerScreen(Customer c) {
        this.customer = c;

        setTitle("Customer Screen - " + c.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // רקע
        ImageIcon im = new ImageIcon("pics/rekalakoj.png");
        JLabel background = new JLabel(im);
        setSize(im.getIconWidth(), im.getIconHeight());
        background.setLayout(null);

        // כפתור להזמנת מונית
        JButton addOrderBtn = new JButton("הוסף הזמנה");
        addOrderBtn.setBounds(150, 250, 150, 30);
        background.add(addOrderBtn);

        // כפתור להצגת ההזמנות שלי
        JButton showOrdersBtn = new JButton("הצג את ההזמנות שלי");
        showOrdersBtn.setBounds(150, 300, 150, 30);
        background.add(showOrdersBtn);

        // ActionListener לכפתור הוספת הזמנה
        addOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Taxi t = SystemDataBase.getTaxis().get(1); // מונית לדוגמה
                MainManager admin = SystemDataBase.getMainManagers().get(0);

                try {
                    OrderService.addOrder(customer, t, admin, 400, 85, "07/09/2025");
                    JOptionPane.showMessageDialog(null, "הזמנה נוספה בהצלחה!");
                } catch (TaxiNotAvailableException ex) {
                    JOptionPane.showMessageDialog(null, "שגיאה: " + ex.getMessage());
                }
            }
        });

        // ActionListener לכפתור הצגת ההזמנות שלי
        showOrdersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder("ההזמנות של " + customer.getName() + ":\n");
                for (Order o : customer.getOrders()) {
                    sb.append(o.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        setContentPane(background);
        setVisible(true);
    }
}
