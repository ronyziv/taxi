package view.viewp;

import javax.swing.*;
import model.MainManager;
import model.Employee;
import control.SystemDataBase;
import service.EmployeeService;
import java.util.ArrayList;

public class AdminScreen extends JFrame {
    private MainManager manager;

    public AdminScreen(MainManager m) {
        this.manager = m;

        setTitle("מסך ניהולי - " + m.getFirstName() + " " + m.getLastName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon im2 = new ImageIcon("pics/rekaMenahel.png");
        JLabel background = new JLabel(im2);
        setSize(im2.getIconWidth(), im2.getIconHeight());
        background.setLayout(null);

        JButton myWorkers = new JButton("הצג עובדים");
        myWorkers.setBounds(150, 280, 120, 30);

        JButton newSalary = new JButton("שנה משכורת");
        newSalary.setBounds(150, 320, 120, 30);

        background.add(myWorkers);
        background.add(newSalary);

        setContentPane(background);
        setVisible(true);
    newSalary.addActionListener(ev -> {
    String id = JOptionPane.showInputDialog("הכנס תעודת זהות של העובד:");
    Employee selected = null;

    for (Employee e : SystemDataBase.getEmployees()) {
        if (e.getId().equals(id)) {
            selected = e;
            break;
        }
    }

    if (selected != null) {
        String input = JOptionPane.showInputDialog("הכנס משכורת חדשה:");
        try {
            double newSalaryValue = Double.parseDouble(input);
            EmployeeService.changeSalary(selected, newSalaryValue);
            JOptionPane.showMessageDialog(this, "המשכורת עודכנה בהצלחה!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "הכנס מספר חוקי");
        }
    } else {
        JOptionPane.showMessageDialog(this, "עובד לא נמצא");
    }
});

        // 📌 ActionListener לכפתור הצגת עובדים
        myWorkers.addActionListener(e -> showMyWorkers());
    }

    // פונקציה שמציגה את העובדים של המנהל הנוכחי
    private void showMyWorkers() {
        // לוקחים את כל העובדים מהמערכת
        ArrayList<Employee> allEmployees = SystemDataBase.getEmployees();

        // סופרים כמה עובדים יש לי
        ArrayList<Employee> myEmployees = new ArrayList<>();
        for (Employee emp : allEmployees) {
            if (emp.getManager().equals(manager)) {
                myEmployees.add(emp);
            }
        }

        // מכינים נתונים לטבלה
        String[] columnNames = {"ID", "שם פרטי", "שם משפחה", "תפקיד", "שכר"};
        Object[][] data = new Object[myEmployees.size()][5];

        for (int i = 0; i < myEmployees.size(); i++) {
            Employee e = myEmployees.get(i);
            data[i][0] = e.getId();
            data[i][1] = e.getFirstName();
            data[i][2] = e.getLastName();
            data[i][3] = e.getRole();
            data[i][4] = e.getSalary();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // מציג בחלון קופץ
        JFrame frame = new JFrame("העובדים שלי");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(this);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
