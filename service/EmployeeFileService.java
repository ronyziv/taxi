package service;

import java.io.*;
import java.util.Scanner;
import model.Employee;
import control.SystemDataBase;
import exceptions.InvalidEmployeeFileException;

public class EmployeeFileService {

    public static void loadEmployeesFromFile(String filename) throws InvalidEmployeeFileException {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 5) {
                    throw new InvalidEmployeeFileException("שורה לא תקינה: " + line);
                }

                String id = parts[0];
                String first = parts[1];
                String last = parts[2];
                String role = parts[3];
                double salary = Double.parseDouble(parts[4]);

                Employee e = new Employee(id, first, last, role, "user", "pass", salary, null);
                SystemDataBase.addEmployee(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("קובץ לא נמצא: " + filename);
        }
    }
}
