package bridge.domain.game;

import bridge.common.ErrorCode;

import java.util.Arrays;

public enum Result {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String message;
    private final boolean isSuccess;

    Result(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public static Result of(boolean type) {
        return Arrays.stream(values())
                .filter(result -> result.isSuccess == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_RESULT.getMessage()));
    }

    public String getMessage() {
        return message;
    }
}
