package bridge.domain.command;

import java.util.List;

public class MoveCommand extends Command {

    public static final String UPPER_BLOCK = "U";
    public static final String LOWER_BLOCK = "D";

    public MoveCommand(String message) {
        super(message);
    }

    @Override
    void addCorrectValues(List<String> correctValues) {
        correctValues.add(UPPER_BLOCK);
        correctValues.add(LOWER_BLOCK);
    }
}
