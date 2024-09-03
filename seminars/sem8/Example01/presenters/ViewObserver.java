package seminars.sem8.Example01.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    boolean onRemoveReservationTable(int oldReservation, int tableNo);

    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
