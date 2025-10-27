package app;

import view.viewp.HomeScreen;

public class App {
    public static void main(String[] args) {
        // נקודת כניסה למערכת - מריצים על ה-EDT
        javax.swing.SwingUtilities.invokeLater(() -> new HomeScreen());
    }
}
