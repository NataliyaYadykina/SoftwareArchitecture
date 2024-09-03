package seminars.sem8.Example01.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import seminars.sem8.Example01.presenters.Model;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     * 
     * @return список столиков
     */
    @Override
    public Collection<Table> loadTables() {

        if (tables == null) {
            tables = new ArrayList<>();
            // Simulate loading tables from a database or other data source
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * 
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя клиента
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Reservation error. Try again later.");
    }

    /**
     * Отменить бронирование столика
     * 
     * @param oldReservation номер бронирования
     * @param tableNo        номер столика
     * @return отменено (true) или нет (false)
     */
    public boolean removeReservationTable(int oldReservation, int tableNo) {
        boolean flag = false;
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                for (Reservation reservation : table.getReservations()) {
                    if (reservation.getId() == oldReservation) {
                        table.getReservations().remove(reservation);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * Поменять бронь столика
     * 
     * @param oldReservation  номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo         номер столика
     * @param name            Имя
     * @return новый номер бронирования столика или -1
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservation = -1;
        if (removeReservationTable(oldReservation, tableNo)) {
            newReservation = reservationTable(reservationDate, tableNo, name);
        }
        return newReservation;
    }

}
