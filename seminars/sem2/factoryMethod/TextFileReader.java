package seminars.sem2.factoryMethod;

import seminars.sem2.templateMethod.LogEntry;
import seminars.sem2.templateMethod.LogReader;

public class TextFileReader extends LogReader {

    @Override
    public Object getDataSource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDataSource'");
    }

    @Override
    public void setDataSource(Object data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataSource'");
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readEntries'");
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseLogEntry'");
    }

}
