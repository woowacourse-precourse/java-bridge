package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private static final String INVALID_CODE_RANGE_MESSAGE = "0과 1사이의 값을 입력해주세요.";
    private static final String INVALID_INITIAL_LETTER_MESSAGE = "U와 D 중 하나의 값을 입력해주세요.";

    private final Integer directionCode;
    private final String initialLetter;

    Direction(Integer directionCode, String initialLetter) {
        this.directionCode = directionCode;
        this.initialLetter = initialLetter;
    }

    public static String toInitialLetter(int directionCode) {
        return Arrays.stream(values())
                .filter(direction -> direction.directionCode == directionCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CODE_RANGE_MESSAGE))
                .initialLetter;
    }

    public static Direction toEnum(String initialLetter) {
        return Arrays.stream(values())
                .filter(direction -> direction.initialLetter.equals(initialLetter))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INITIAL_LETTER_MESSAGE));
    }

    public boolean isNotSameDirection(Direction direction) {
        return this != direction;
    }
}
