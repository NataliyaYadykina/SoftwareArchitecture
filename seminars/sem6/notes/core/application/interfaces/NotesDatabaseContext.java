package seminars.sem6.notes.core.application.interfaces;

import java.util.Collection;

import seminars.sem6.notes.core.domain.Note;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    boolean saveChanges();

}
