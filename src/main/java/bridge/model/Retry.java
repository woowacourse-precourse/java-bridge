package bridge.model;

import static bridge.exception.GameCommandException.validate;

import java.util.Objects;

public class Retry {

    public static final String RETRY = "R";

    private int count;

    public Retry() {
        this.count = 1;
    }

    public Retry(int count) {
        this.count = count;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Retry retry = (Retry) o;
        return count == retry.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
