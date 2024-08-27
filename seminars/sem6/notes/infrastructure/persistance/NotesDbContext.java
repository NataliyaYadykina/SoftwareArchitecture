package seminars.sem6.notes.infrastructure.persistance;

import java.util.ArrayList;
import java.util.Collection;

import seminars.sem6.database.NotesDatabase;
import seminars.sem6.database.NotesRecord;
import seminars.sem6.notes.core.application.interfaces.NotesDatabaseContext;
import seminars.sem6.notes.core.domain.Note;
import seminars.sem6.notes.infrastructure.persistance.configurations.NoteConfiguration;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        // TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм
        // фреймворка
        for (NotesRecord record : ((NotesDatabase) database).getNotesTable().getRecords()) {
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()));
        }
        return notesList;
    }

}
