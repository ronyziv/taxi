package model;

import java.util.ArrayList;

public class Customer extends User {
    private int id111;
    private ArrayList<Order> orders;

    public Customer(int id, String name) {
        super(name, "", "", ""); // Customer לא צריך username/password
        this.id = id111;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public String getName() {
        return getFirstName(); // Customer name הוא firstName
    }

    public int getId() {
        return id111;
    }

    @Override
    public String toString() {
        return "Customer #" + id111 + " - " + getName() + " | הזמנות: " + orders.size();
    }
}
