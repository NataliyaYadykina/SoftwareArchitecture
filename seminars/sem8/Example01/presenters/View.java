package seminars.sem8.Example01.presenters;

import java.util.Collection;
import java.util.Date;

import seminars.sem8.Example01.models.Table;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * 
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * 
     * @param reservationNo Номер брони
     */
    void showReservationTableResult(int reservationNo);

    /**
     * Установить наблюдателя для представления
     * 
     * @param observer Наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Событие: Клиент нажал кнопку резервации столика
     * 
     * @param orderDate Дата брони
     * @param tableNo   Номер столика
     * @param name      Имя клиента
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Отобразить результат удаления брони
     * 
     * @param oldReservation номер бронирования
     * @param removeStatus   удален или нет
     * @param tableNo        номер столика
     */
    void showRemoveReservationStatus(int oldReservation, boolean removeStatus, int tableNo);

    /**
     * Отобразить результат изменения бронирования столика
     * 
     * @param oldReservation старый номер бронирования столика
     * @param newReservation новый номер бронирования столика
     * @param tableNo        номер столика
     */
    void showChangeReservationStatus(int oldReservation, int newReservation, int tableNo);

}
