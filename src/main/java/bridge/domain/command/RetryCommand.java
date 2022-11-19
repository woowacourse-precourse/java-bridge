package bridge.domain.command;

import java.util.List;

public class RetryCommand extends Command {

    public static final String RESTART_GAME = "R";
    public static final String CLOSE_GAME = "Q";

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
