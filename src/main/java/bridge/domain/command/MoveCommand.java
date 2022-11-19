package bridge.domain.command;

import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;

import java.util.List;

public class MoveCommand extends Command {

    public MoveCommand(String message) {
        super(message);
    }

    @Override
    void addCorrectValues(List<String> correctValues) {
        correctValues.add(UPPER_BLOCK);
        correctValues.add(LOWER_BLOCK);
    }
}
