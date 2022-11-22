package bridge.domain;

public enum Victory {
    VICTORY("성공"),
    DEFEAT("실패");

    private static final long ZERO_FAIL = 0L;

    private final String message;

    Victory(String message) {
        this.message = message;
    }

    public static Victory getEnum(long FailCount) {
        if (FailCount == ZERO_FAIL) {
            return VICTORY;
        }
        return DEFEAT;
    }

    public boolean isVictory() {
        return this == VICTORY;
    }

    public String getMessage() {
        return message;
    }
}
