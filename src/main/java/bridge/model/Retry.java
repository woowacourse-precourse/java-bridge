package bridge.model;

import static bridge.exception.GameCommandException.validate;

public class Retry {

    public static final String RETRY = "R";

    private int count;

    public Retry() {
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void countTry() {
        this.count += 1;
    }

    public boolean checkRetry(String gameCommand) {
        validate(gameCommand);
        return gameCommand.equals(RETRY);
    }
}
