package seminars.sem8.Example01.presenters;

import java.util.Collection;
import java.util.Date;

import seminars.sem8.Example01.models.Table;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     * 
     * @return Коллекция столиков
     */
    public Collection<Table> loadTables() {
        return model.loadTables();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    public void updateUIShowReservationResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    /**
     * Произошло событие: пользователь нажал на кнопку резерва столика
     * 
     * @param orderDate Дата резерва
     * @param tableNo   Номер столика
     * @param name      Имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationResult(reservationNo);
        } catch (RuntimeException e) {
            updateUIShowReservationResult(-1);
        }
    }

    /**
     * Отобразить результат отмены бронирования столика
     * 
     * @param oldReservation номер брони
     * @param removeStatus   статус попытки удаления брони
     * @param tableNo        номер столика
     */
    private void updateRemoveReservationStatusView(int oldReservation, boolean removeStatus, int tableNo) {
        view.showRemoveReservationStatus(oldReservation, removeStatus, tableNo);
    }

    /**
     * Отобразить результат изменения бронирования столика
     * 
     * @param oldReservation старый номер брони
     * @param newReservation новый номер брони
     * @param tableNo        номер столика
     */
    private void updateChangeReservationStatusView(int oldReservation, int newReservation, int tableNo) {
        view.showChangeReservationStatus(oldReservation, newReservation, tableNo);
    }

    /**
     * Получили уведомление о попытке удаления брони
     * 
     * @param oldReservation номер бронирования
     */
    @Override
    public boolean onRemoveReservationTable(int oldReservation, int tableNo) {
        boolean removeStatus = model.removeReservationTable(oldReservation, tableNo);
        updateRemoveReservationStatusView(oldReservation, removeStatus, tableNo);
        return removeStatus;
    }

    /**
     * Получили уведомления о попытке редактирования брони
     * 
     * @param oldReservation  номер старой брони
     * @param reservationDate новая дата бронирования
     * @param tableNo         номер нового столика
     * @param name            имя клиента
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservation = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateChangeReservationStatusView(oldReservation, newReservation, tableNo);
    }

}
