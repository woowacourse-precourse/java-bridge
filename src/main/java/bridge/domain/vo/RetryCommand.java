package bridge.domain.vo;

import java.util.List;

public class RetryCommand extends Command {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    public RetryCommand(String message) {
        super(message);
    }

    @Override
    protected List<String> getCorrectValues() {
        return List.of(RETRY, QUIT);
    }

    public boolean isRetry() {
        return getMessage().equals(RETRY);
    }
}
