package seminars.sem8.Example01.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;

    private final int id;
    private Table table;
    private Date date;
    private String name;

    {
        id = counter++;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Reservation #%s, Table %s, Date: %s, Client: %s", id, table.getNo(), date, name);
    }

}
