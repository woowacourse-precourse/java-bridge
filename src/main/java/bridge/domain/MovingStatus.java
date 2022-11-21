package bridge.domain;

import java.util.Arrays;

public enum MovingStatus {
    UP(1, "U"),
    DOWN(0, "D"),
    FAIL(-1, "-");

    private final int statusNumber;
    private final String movingKey;

    MovingStatus(final int statusNumber, final String movingKey) {
        this.statusNumber = statusNumber;
        this.movingKey = movingKey;
    }

    public String getMovingKey() {
        return movingKey;
    }

    public String sideFail() {
        return FAIL.getMovingKey() + movingKey;
    }

    public static MovingStatus find(int statusNumber) {
        return Arrays.stream(values())
                .filter(move -> move.statusNumber == statusNumber)
                .findAny()
                .orElse(null);
    }
}
