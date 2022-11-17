package bridge.domain;

import java.util.Arrays;

public enum BridgeStatus {
    UP(1, "U"),
    DOWN(0, "D");

    private final int value;
    private final String mark;

    BridgeStatus(int value, String status) {
        this.value = value;
        this.mark = status;
    }

    private int getValue() {
        return value;
    }

    private String getMark() {
        return mark;
    }

    public static String findMark(int randomValue) {
        return Arrays.stream(BridgeStatus.values())
                .filter(status -> status.getValue() == randomValue)
                .findAny()
                .get().getMark();
    }
}
