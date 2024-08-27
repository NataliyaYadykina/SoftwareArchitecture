package seminars.sem6.notes.core.application.interfaces;

import seminars.sem6.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

}
