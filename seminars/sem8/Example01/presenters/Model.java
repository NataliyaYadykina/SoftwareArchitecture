package seminars.sem8.Example01.presenters;

import java.util.Collection;
import java.util.Date;

import seminars.sem8.Example01.models.Table;

public interface Model {

    /**
     * Получение всех доступных столиков в ресторане
     * 
     * @return столики
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столиков
     * 
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            имя клиента
     * @return номер брони
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Отменить бронирование столика
     * 
     * @param oldReservation номер бронирования
     * @param tableNo        номер столика
     * @return отменено (true) или нет (false)
     */
    boolean removeReservationTable(int oldReservation, int tableNo);

    /**
     * Поменять бронь столика
     * 
     * @param oldReservation  номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo         номер столика
     * @param name            Имя
     * @return новый номер бронирования столика или -1
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
