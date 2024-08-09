package seminars.sem1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 2000;

    private int id;
    private LocalDateTime orderDate;
    private String address;
    private String phone;
    private Buyer buyer;

    private List<OrderItem> items = new ArrayList<>();

    {
        id = counter++;
    }

    public Order(LocalDateTime orderDate, String address, String phone, Buyer buyer, List<OrderItem> items) {

        if (buyer == null) {
            throw new RuntimeException("Buyer must not be null");
        }

        if (items == null || items.size() == 0) {
            throw new RuntimeException("Items must not be null or empty");
        }

        this.orderDate = orderDate;
        this.address = address;
        this.phone = phone;
        this.buyer = buyer;
        this.items = items;
    }

    public int getId() {
        return id;
    }

}
