package control;

import java.util.ArrayList;
import model.*;

public class SystemDataBase {
    private static ArrayList<MainManager> mainManagers = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Taxi> taxis = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static ArrayList<MainManager> getMainManagers() { return mainManagers; }
    public static ArrayList<Employee> getEmployees() { return employees; }
    public static ArrayList<Customer> getCustomers() { return customers; }
    public static ArrayList<Taxi> getTaxis() { return taxis; }
    public static ArrayList<Order> getOrders() { return orders; }

    // CRUD
    public static void addMainManager(MainManager m) { mainManagers.add(m); }
    public static void addEmployee(Employee e) { employees.add(e); }
    public static void addCustomer(Customer c) { customers.add(c); }
    public static void addTaxi(Taxi t) { taxis.add(t); }
    public static void addOrder(Order o) { orders.add(o); }

    // ⚡ בלוק סטטי – מאתחל נתונים
    static {
        // MainManagers (5)
        MainManager m1 = new MainManager("רוני", "זיו", "rziv", "12345");
        MainManager m2 = new MainManager("שרה", "כהן", "sara", "abcd");
        MainManager m3 = new MainManager("יוסי", "לוי", "yossi", "pass1");
        MainManager m4 = new MainManager("נועה", "בר", "noa", "pass2");
        MainManager m5 = new MainManager("חיים", "כהן", "haim", "pass3");
        addMainManager(m1); addMainManager(m2); addMainManager(m3); addMainManager(m4); addMainManager(m5);

        // Employees (5) – עם מנהלים משויכים
        addEmployee(new Employee("E1", "דני", "ישראלי", "נהג", "emp1", "1111", 5000, m1));
        addEmployee(new Employee("E2", "מאיה", "כהן", "פקידת קבלה", "emp2", "2222", 4500, m2));
        addEmployee(new Employee("E3", "עומר", "ברק", "נהג", "emp3", "3333", 4800, m3));
        addEmployee(new Employee("E4", "ליאת", "כהן", "נהגת", "emp4", "4444", 5100, m4));
        addEmployee(new Employee("E5", "תומר", "לוי", "פקיד", "emp5", "5555", 4600, m5));

        // Customers (5)
        addCustomer(new Customer(1, "דוד לוי"));
        addCustomer(new Customer(2, "אורית ישראלי"));
        addCustomer(new Customer(3, "רון בר"));
        addCustomer(new Customer(4, "נועה גפן"));
        addCustomer(new Customer(5, "שלומי כהן"));

        // Taxis (5 – חלק תפוסות, חלק פנויות)
        Taxi t1 = new Taxi("T1", 50, false); // פנויה
        Taxi t2 = new Taxi("T2", 40, true);  // תפוסה
        Taxi t3 = new Taxi("T3", 60, false);
        Taxi t4 = new Taxi("T4", 55, true);
        Taxi t5 = new Taxi("T5", 45, false);
        addTaxi(t1); addTaxi(t2); addTaxi(t3); addTaxi(t4); addTaxi(t5);

        // Orders (5 – לקוחות מול מוניות)
        addOrder(new Order(101, customers.get(0), t1, m1, 70, "01/09/2025"));
        addOrder(new Order(102, customers.get(1), t2, m2, 65, "02/09/2025"));
        addOrder(new Order(103, customers.get(2), t3, m3, 80, "03/09/2025"));
        addOrder(new Order(104, customers.get(3), t4, m4, 60, "04/09/2025"));
        addOrder(new Order(105, customers.get(4), t5, m5, 75, "05/09/2025"));
    }
}
