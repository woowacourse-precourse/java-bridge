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

    public static GameRetry parseDirection(String directionValue) {
        if (directionValue == RETRY.asString)
            return RETRY;
        if (directionValue == QUIT.asString)
            return QUIT;
        throw new CustomIllegalArgumentException(
                "비정상적인 값"
        );
    }
}
