package model;

public class Employee extends User {
    private String id;
    private String role;
    private double salary;
    private MainManager manager;

    public Employee(String id, String firstName, String lastName, String role,
                    String username, String password, double salary, MainManager manager) {
        super(firstName, lastName, username, password);
        this.id = id;
        this.role = role;
        this.salary = salary;
        this.manager = manager;
    }

    public String getId() { return id; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public MainManager getManager() { return manager; }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name=" + getFirstName() + " " + getLastName() +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", manager=" + (manager != null ? manager.getFirstName() : "none") +
                '}';
    }
}