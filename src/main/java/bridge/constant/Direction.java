package bridge.constant;

import java.util.Arrays;

public enum Direction {
    UPPER("U", 1),
    LOWER("D", 0);

    private final String capitalLetter;
    private final int bridgeNumber;

    Direction(String capitalLetter, int bridgeNumber) {
        this.capitalLetter = capitalLetter;
        this.bridgeNumber = bridgeNumber;
    }

    public static Direction from(String capitalLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.hasCapitalLetter(capitalLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("문자열로 방향을 찾을 수 없습니다"));
    }

    public static Direction from(int bridgeNumber) {
        return Arrays.stream(values())
                .filter(direction -> direction.hasBridgeNumber(bridgeNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자로 방향을 찾을 수 없습니다"));
    }

    private boolean hasCapitalLetter(String capitalLetter) {
        return this.capitalLetter.equals(capitalLetter);
    }

    private boolean hasBridgeNumber(int bridgeNumber) {
        return this.bridgeNumber == bridgeNumber;
    }

    public String capitalLetter() {
        return capitalLetter;
    }

    public int bridgeNumber() {
        return bridgeNumber;
    }
}
