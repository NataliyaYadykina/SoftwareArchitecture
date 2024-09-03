package seminars.sem8.Example01;

import java.util.Date;

import seminars.sem8.Example01.models.TableModel;
import seminars.sem8.Example01.presenters.BookingPresenter;
import seminars.sem8.Example01.presenters.Model;
import seminars.sem8.Example01.views.BookingView;

public class Program {

    public static void main(String[] args) {

        BookingView view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 3, "Наталья");
        view.reservationTable(new Date(), 3, "Владимир");

        view.changeReservationTable(1005, new Date(), 3, "Наталья");
        view.changeReservationTable(1001, new Date(), 3, "Наталья");

        view.removeReservationTable(1002, 3);
        view.removeReservationTable(1004, 3);

    }

}
