package bridge.domain.command;

import java.util.List;

public class RetryCommand extends Command {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    public RetryCommand(String message) {
        super(message);
    }

    @Override
    void addCorrectValues(List<String> correctValues) {
        correctValues.add(RETRY);
        correctValues.add(QUIT);
    }

    public boolean isRetry() {
        return getMessage().equals(RETRY);
    }
}
