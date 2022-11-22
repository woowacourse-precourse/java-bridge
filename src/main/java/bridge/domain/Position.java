package bridge.domain;

import java.util.Arrays;

public enum Position {
    UP(1, "U"),
    DOWN(0, "D");

    private final int positionNumber;
    private final String positionValue;

    Position(int positionNumber, String positionValue) {
        this.positionNumber = positionNumber;
        this.positionValue = positionValue;
    }

    public static String convertNumberToValue(int number) {
        return Arrays.stream(Position.values())
                .filter(position -> position.positionNumber == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 0 또는 1의 값만 가능합니다."))
                .positionValue;
    }
}
