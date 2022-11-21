package bridge.domain.game;

import bridge.common.ErrorCode;

import java.util.Arrays;

public enum Retry {
    RETRY("R", true),
    QUIT("Q", false);

    private final String type;
    private final boolean isRetry;

    Retry(String type, boolean isRetry) {
        this.type = type;
        this.isRetry = isRetry;
    }

    public static Retry of(String type) {
        return Arrays.stream(values())
                .filter(retry -> retry.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_RETRY.getMessage()));
    }

    public boolean isRetry() {
        return isRetry;
    }
}
