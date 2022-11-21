package bridge.domain;

import java.util.List;

public enum PlayIndicator {
    REPLAY("R", true),
    QUIT("Q", false);

    private final String message;
    private final boolean retryFlag;

    PlayIndicator(String message, boolean retryFlag) {
        this.message = message;
        this.retryFlag = retryFlag;
    }

    public static List<String> all() {
        return List.of(REPLAY.message, QUIT.message);
    }
}
