package seminars.sem8.Example01.views;

import java.util.Collection;
import java.util.Date;

import seminars.sem8.Example01.models.Table;
import seminars.sem8.Example01.presenters.View;
import seminars.sem8.Example01.presenters.ViewObserver;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * 
     * @param orderDate Дата бронирования
     * @param tableNo   Номер столика
     * @param name      Имя клиента
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null) {
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер Вашей брони: #%d\n", reservationNo);
        } else {
            System.out.println("Бронирование столика не удалось.");
        }
    }

    /**
     * Отобразить результат удаления брони
     * 
     * @param oldReservation номер бронирования
     * @param removeStatus   удален или нет
     * @param tableNo        номер столика
     */
    @Override
    public void showRemoveReservationStatus(int oldReservation, boolean removeStatus, int tableNo) {
        if (removeStatus) {
            System.out.printf("Бронирование #%d столика #%d успешно отменено.\n", oldReservation, tableNo);
        } else {
            System.out.printf("Ошибка отмены бронирования #%d столика #%d.\n", oldReservation, tableNo);
        }
    }

    /**
     * Отобразить результат изменения бронирования столика
     * 
     * @param oldReservation старый номер бронирования столика
     * @param newReservation новый номер бронирования столика
     * @param tableNo        номер столика
     */
    @Override
    public void showChangeReservationStatus(int oldReservation, int newReservation, int tableNo) {
        if (newReservation > 0) {
            System.out.printf("Бронирование #%d отменено. Новый номер брони: #%d\n", oldReservation, newReservation);
        } else {
            System.out.printf("Ошибка редактирования брони #%d столика #%d.\n", oldReservation, tableNo);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку Удалить Бронирование столика)
     * 
     * @param oldReservation номер бронирования
     */
    public void removeReservationTable(int oldReservation, int tableNo) {
        observer.onRemoveReservationTable(oldReservation, tableNo);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * 
     * @param oldReservation  идентификатор бронирования
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

}
