package bridge.domain.command;

import java.util.List;

public class MoveCommand extends Command {

    public static final String MOVE_TO_UPPER_BLOCK = "U";
    public static final String MOVE_TO_LOWER_BLOCK = "D";

    public MoveCommand(String message) {
        super(message);
    }

    @Override
    void addCorrectValues(List<String> correctValues) {
        correctValues.add(MOVE_TO_UPPER_BLOCK);
        correctValues.add(MOVE_TO_LOWER_BLOCK);
    }
}
