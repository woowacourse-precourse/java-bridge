package bridge.domain;

import java.util.Arrays;

public enum GameStatus {
    SUCCESS("성공", true, true),
    FAILED("실패", false, false),
    PLAYING("진행 중", true, false);

    private final String status;

    private final boolean isCrossed;
    private final boolean isReached;

    GameStatus(String status, boolean isCrossed, boolean isReached) {
        this.status = status;
        this.isCrossed = isCrossed;
        this.isReached = isReached;
    }

    public String getStatus() {
        return status;
    }

    public static GameStatus findByStatus(boolean isCrossed, boolean isReached) {
        return Arrays.stream(values())
                .filter(value -> value.isCrossed == isCrossed)
                .filter(value -> value.isReached == isReached)
                .findAny()
                .orElse(FAILED);
    }
}
