package bridge.domain;

import java.util.Arrays;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private int number;
    private String word;

    BridgeDirection(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public static BridgeDirection numberToDirection(int number) {
        return Arrays.stream(BridgeDirection.values())
                .filter(location -> location.number == number)
                .findAny()
                .orElseThrow();
    }

    public static BridgeDirection wordToDirection(String word) {
        return Arrays.stream(BridgeDirection.values())
                .filter(location -> location.word.equals(word))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("U 또는 D만 입력 가능합니다."));
    }
}
