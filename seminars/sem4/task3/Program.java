package seminars.sem4.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн-билетов на автобус
     * в час-пик".
     * 
     * 5, 6, 7, 8, 10 - необязательные, опциональные задания.
     * 
     * 1. Предусловия.
     * 2. Постусловия.
     * 3. Инвариант.
     * 4. Определить абстрактные и конкретные классы.
     * 5. Определить интерфейсы.
     * 6. Реализовать наследование.
     * 7. Выявить компоненты.
     * 8. Разработать диаграмму компонент, используя нотацию UML 2.0. Общая, без
     * деталей.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Напиши код здесь
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        if (mobileApp.buyTicket("4561236456")) {
            System.out.println("Клиент успешно купил билет.");
            mobileApp.searchTicket(new Date());
            Collection<Ticket> tickets = mobileApp.getTickets();
            if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Клиент успешно прошел в автобус.");
            }
        }
    }

}

/**
 * Ядро системы
 */
class Core {
    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final DataBase dataBase;

    public Core() {
        dataBase = new DataBase();
        customerProvider = new CustomerProvider(dataBase);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(dataBase, paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }
}

/**
 * Покупатель
 */
class Customer {

    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;

    {
        id = counter++;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}

/**
 * Билет
 */
class Ticket {

    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

}

/**
 * База данных
 */
class DataBase {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public DataBase() {
        tickets.add(new Ticket());
        tickets.add(new Ticket());
        tickets.add(new Ticket());
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * 
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * 
     * @param clientId
     * @return
     */
    public int createTicketOrder(int clientId) {
        return counter++;
    }

}

class PaymentProvider {

    public boolean buyTicket(int orderId, String cardNo, double amount) {
        // TODO: Обращение к платежному шлюзу, попытка выполнить списание средств...
        return true;
    }
}

/**
 * Мобильное приложение
 */
class MobileApp {

    private final Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer("login", "password");
    }

    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public void searchTicket(Date date) {
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo) {
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}

class TicketProvider {

    private DataBase database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(DataBase database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo) {

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        return paymentProvider.buyTicket(orderId, cardNo, amount);

    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

}

class CustomerProvider {

    private DataBase dataBase;

    public CustomerProvider(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Customer getCustomer(String login, String password) {
        return new Customer();
    }

}

/**
 * Автобусная станция
 */
class BusStation {
    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public boolean checkTicket(String qrCode) {
        return ticketProvider.checkTicket(qrCode);
    }
}
