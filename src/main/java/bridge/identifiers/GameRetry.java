package bridge.identifiers;

import java.util.Objects;

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
        if (Objects.equals(retryValue, RETRY.asString))
            return RETRY;
        if (Objects.equals(retryValue, QUIT.asString))
            return QUIT;
        throw new IllegalArgumentException(
                RETRY.asString + " 또는 " + QUIT.asString + " 을 입력해야 합니다."
        );
    }
}
