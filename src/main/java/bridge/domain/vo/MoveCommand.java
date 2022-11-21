package bridge.domain.vo;

import java.util.List;

public class MoveCommand extends Command {

    public static final String MOVE_TO_UPPER_BLOCK = "U";
    public static final String MOVE_TO_LOWER_BLOCK = "D";

    public MoveCommand(String message) {
        super(message);
    }

    @Override
    protected List<String> getCorrectValues() {
        return List.of(MOVE_TO_UPPER_BLOCK, MOVE_TO_LOWER_BLOCK);
    }
}
