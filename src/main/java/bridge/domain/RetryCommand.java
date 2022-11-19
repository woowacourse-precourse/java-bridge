package bridge.domain;

import static bridge.constant.BridgeConstant.CLOSE_GAME;
import static bridge.constant.BridgeConstant.RESTART_GAME;

import java.util.List;

public class RetryCommand extends Command {


    public RetryCommand(String message) {
        super(message);
    }

    @Override
    void addCorrectValues(List<String> correctValues) {
        correctValues.add(RESTART_GAME);
        correctValues.add(CLOSE_GAME);
    }

    public boolean isRetry() {
        return getMessage().equals(RESTART_GAME);
    }
}
