package seminars.sem6.notes.presentation.queries.views;

import java.util.Collection;

import seminars.sem6.notes.core.application.interfaces.NotesPresenter;
import seminars.sem6.notes.core.domain.Note;

public class NotesConsolePresenter implements NotesPresenter {

    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

}
