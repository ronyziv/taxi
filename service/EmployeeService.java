package service;

import model.Employee;

public class EmployeeService {
    public static void changeSalary(Employee e, double newSalary) {
        if (newSalary < 0) {
            throw new IllegalArgumentException("משכורת לא יכולה להיות שלילית");
        }
        e.setSalary(newSalary);
    }
}
