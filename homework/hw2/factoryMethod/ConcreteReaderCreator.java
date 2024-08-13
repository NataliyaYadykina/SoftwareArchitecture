package homework.hw2.factoryMethod;

import homework.hw2.templateMethod.LogReader;
import homework.hw2.templateMethod.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator {

    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType) {
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DataBaseReader();
            case System -> new OperationSystemLogEventReader();
            default -> throw new IllegalArgumentException("Unsupported log type: " + logType);
        };
    }

}
