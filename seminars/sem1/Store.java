package seminars.sem1;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Order> orders = new ArrayList<>();

    public boolean addOrder(Order order) {
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    public boolean paymentOrder(int id) {
        return true;
    }

}
