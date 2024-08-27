package seminars.sem6;

import seminars.sem6.database.NotesDatabase;
import seminars.sem6.notes.core.application.ConcreteNoteEditor;
import seminars.sem6.notes.infrastructure.persistance.NotesDbContext;
import seminars.sem6.notes.presentation.queries.controllers.NotesController;
import seminars.sem6.notes.presentation.queries.views.NotesConsolePresenter;

public class Program {

    public static void main(String[] args) {

        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        controller.routeGetAll();

    }

}
