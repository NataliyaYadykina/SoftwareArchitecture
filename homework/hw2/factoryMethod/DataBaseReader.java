package homework.hw2.factoryMethod;

import homework.hw2.templateMethod.LogEntry;
import homework.hw2.templateMethod.LogReader;

public class DataBaseReader extends LogReader {

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
