package model;

public class Order {
    private int orderId;
    private Customer customer;
    private Taxi taxi;
    private MainManager manager;  // ← שינוי מ-Manager ל-MainManager
    private double price;
    private String date;

    public Order(int orderId, Customer customer, Taxi taxi, MainManager manager, double price, String date) {
        this.orderId = orderId;
        this.customer = customer;
        this.taxi = taxi;
        this.manager = manager;
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Order #" + orderId +
               "\nCustomer: " + customer.getName() +
               "\nTaxi: " + taxi.getCode() +
               "\nManager: " + manager.getFirstName() +
               "\nPrice: " + price +
               "\nDate: " + date;
    }
}
