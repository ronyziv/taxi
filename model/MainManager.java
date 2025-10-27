package model;

public class MainManager extends User {

    public MainManager(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    @Override
    public String toString() {
        return "MainManager{" +
                "name=" + getFirstName() + " " + getLastName() +
                ", username=" + getUsername() +
                '}';
    }
}