package bridge.identifiers;

import bridge.exceptions.CustomIllegalArgumentException;
import bridge.exceptions.CustomIllegalStateException;

public enum GameRetry {
    RETRY("R"), QUIT("Q");

    private String asString;

    GameRetry(String stringValue) {
        this.asString = stringValue;
    }

    public String getAsString() {
        return asString;
    }

    public static GameRetry parseRetry(String retryValue) {
        if (retryValue == RETRY.asString)
            return RETRY;
        if (retryValue == QUIT.asString)
            return QUIT;
        throw new CustomIllegalArgumentException(
                "비정상적인 값"
        );
    }
}
