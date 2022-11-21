package bridge.domain.game;

import static bridge.support.ErrorMessage.TOO_MANY_ATTEMPTS;

public class Attempt {

    private int attempt;

    public Attempt() {
        this.attempt = 1;
    }

    public int getAttempt() {
        return attempt;
    }

    public void addAttempt() {
        checkTooManyAttempts();
        attempt++;
    }

    private void checkTooManyAttempts() {
        if (Integer.MAX_VALUE == attempt) {
            throw new IllegalArgumentException(TOO_MANY_ATTEMPTS);
        }
    }
}
