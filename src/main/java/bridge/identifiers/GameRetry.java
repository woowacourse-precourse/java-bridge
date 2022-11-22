package bridge.identifiers;

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
        throw new IllegalArgumentException(
                RETRY.asString + " 또는 " + QUIT.asString + " 을 입력해야 합니다."
        );
    }
}
