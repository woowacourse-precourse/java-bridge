package bridge.domain;

import java.util.Arrays;

public enum ProgressStatus {
    SUCCESS("성공", true, true),
    FAILED("실패", false, false),
    ONGOING("진행 중", true, false);

    private String progress;

    private boolean isCrossed;
    private boolean isReached;

    ProgressStatus(String progress, boolean isCrossed, boolean isReached) {
        this.progress = progress;
        this.isCrossed = isCrossed;
        this.isReached = isReached;
    }

    public static ProgressStatus findByStatus(boolean isCrossed, boolean isReached) {
        return Arrays.stream(values())
                .filter(value -> value.isCrossed == isCrossed)
                .filter(value -> value.isReached == isReached)
                .findAny()
                .orElse(FAILED);
    }
}
