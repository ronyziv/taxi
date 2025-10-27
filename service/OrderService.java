package service;

import control.SystemDataBase;
import model.*;
import exceptions.TaxiNotAvailableException;

public class OrderService {

    public static void addOrder(Customer c, Taxi t, MainManager m, int orderId, double price, String date)
            throws TaxiNotAvailableException {

        if (t.isBusy()) {
            throw new TaxiNotAvailableException("המונית " + t.getCode() + " כבר תפוסה!");
        }

        Order o = new Order(orderId, c, t, m, price, date);
        SystemDataBase.addOrder(o);

        // מוסיפים את ההזמנה גם ללקוח
        c.addOrder(o);

        // מסמנים שהמונית תפוסה
        t.setBusy(true);
    }
}
