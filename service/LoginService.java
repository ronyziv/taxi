package service;

import control.SystemDataBase;
import model.*;

public class LoginService {
    public static User login(String username, String password) {
        username = username.trim();
        password = password.trim();

        // בדיקה אצל מנהלים ראשיים
        for (MainManager m : SystemDataBase.getMainManagers()) {
            System.out.println("בודק מנהל: " + m.getUsername() + " / " + m.getPassword());
            if (m.getUsername().equalsIgnoreCase(username) && m.getPassword().equals(password)) {
                return m;
            }
        }

        // בדיקה אצל עובדים
        for (Employee e : SystemDataBase.getEmployees()) {
            System.out.println("בודק עובד: " + e.getUsername() + " / " + e.getPassword());
            if (e.getUsername().equalsIgnoreCase(username) && e.getPassword().equals(password)) {
                return e;
            }
        }

        // לא נמצא
        return null;
    }
}
