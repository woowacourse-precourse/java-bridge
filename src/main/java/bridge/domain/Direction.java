package bridge.domain;

import java.util.Arrays;

public enum Direction {
    D("D", 0),
    U("U", 1);

    private static final String INVALID_INTEGER_ERROR_MESSAGE = "[ERROR] 방향으로 전환 될 수 없는 숫자의 입력 입니다.";
    private static final String INVALID_STRING_ERROR_MESSAGE = "[ERROR] 방향으로 전환 될 수 없는 문자열의 입력 입니다.";

    private final String directionString;
    private final int directionNumber;

    Direction(String direction, int directionNumber) {
        this.directionString = direction;
        this.directionNumber = directionNumber;
    }

    public static String getDirectionStringByNumber(int directionNumber) {
        return Arrays.stream(Direction.values())
                .filter(dir -> dir.directionNumber == directionNumber)
                .map(dir -> dir.directionString)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INTEGER_ERROR_MESSAGE));
    }

    public static Direction getDirectionByString(String direction) {
        return Arrays.stream(Direction.values())
                .filter(dir -> dir.directionString.equals(direction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_STRING_ERROR_MESSAGE));
    }

}
