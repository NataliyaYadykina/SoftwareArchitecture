package homework.hw4.Interfaces;

import homework.hw4.Core.UserProvider;
import homework.hw4.Models.Ticket;
import homework.hw4.Models.User;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс взаимодействия с клиентским приложением
 */
public interface ICustomer {
    List<Ticket> getSelectedTickets();

    void setSelectedTickets(List<Ticket> selectedTickets);

    User getUser();

    void setUser(User client);

    UserProvider getUserProvider();

    /**
     * Метод покупки билета
     *
     * @param ticket билет
     * @return успешность выполненной операции
     * @throws RuntimeException
     */
    boolean buyTicket(Ticket ticket) throws RuntimeException;

    /**
     * Метод поиска билетов по дате и номеру маршрута
     *
     * @param date  дата
     * @param route номер маршрута
     * @return список доступных для приобретения билетов
     * @throws RuntimeException
     */
    List<Ticket> searchTicket(Date date, int route) throws RuntimeException;
}
