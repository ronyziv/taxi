package view.viewp;

import model.Employee;
import javax.swing.*;

public class EmployeeScreen extends JFrame {
    private Employee employee;

    public EmployeeScreen(Employee e) {
        this.employee = e;

        setTitle("Employee Screen - " + e.getFirstName());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea details = new JTextArea(employee.toString());
        add(details);

        setVisible(true);
    }
}
// פה תיקנתי: ווידאתי שיש import ל-Employee, הוספתי JFrame נכון עם setVisible(true), ושם המחלקה וה-package תואמים.
