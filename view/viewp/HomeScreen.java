package view.viewp;

import model.*;
import service.LoginService;
import javax.swing.*;
import java.awt.event.*;

public class HomeScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public HomeScreen() {
        setTitle("Home Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // רקע
        ImageIcon im = new ImageIcon("pics/reka.png");
        JLabel background = new JLabel(im);
        setSize(im.getIconWidth(), im.getIconHeight());
        background.setLayout(null);

        // שדות
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 30);
        background.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 150, 30);
        background.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 30);
        background.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 150, 30);
        background.add(passwordField);

        // כפתור
        loginButton = new JButton("התחבר");
        loginButton.setBounds(150, 200, 100, 30);
        background.add(loginButton);

        // ActionListener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                User user = LoginService.login(username, password);

                if (user != null) {
                    JOptionPane.showMessageDialog(null, "ברוך הבא " + user.getUsername());
                    dispose();
                    if (user instanceof MainManager) {
                        new AdminScreen((MainManager) user);
                    } else if (user instanceof Employee) {
                        new EmployeeScreen((Employee) user);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "שם משתמש או סיסמה לא נכונים. נסי: rziv/12345 או emp1/1111\nהוקלד: " + username);
                }
            }
        });

        setContentPane(background);
        setVisible(true);
    }
}
// פה תיקנתי: ווידאתי imports, ווידאתי trim ל-username/password, והוספתי dispose() לפני מעבר למסך חדש.
