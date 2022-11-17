package bridge.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    D("D", 0),
    U("U", 1);

    private static final String INVALID_INTEGER_ERROR_MESSAGE = "[ERROR] 방향으로 전환 될 수 없는 숫자의 입력 입니다.";
    private static final String INVALID_STRING_ERROR_MESSAGE = "[ERROR] 방향으로 전환 될 수 없는 문자열의 입력 입니다.";

    private String directionString;
    private int directionNumber;

    Direction(String direction, int directionNumber) {
        this.directionString = direction;
        this.directionNumber = directionNumber;
    }

    public String getDirectionString() {
        return directionString;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public static String getDirectionStringByNumber(int directionNumber) {
        Optional<String> resultDirection = Arrays.stream(Direction.values())
                .filter(dir -> dir.getDirectionNumber() == directionNumber)
                .map(dir -> dir.getDirectionString())
                .findAny();
        resultDirection.orElseThrow(() -> new IllegalArgumentException(INVALID_INTEGER_ERROR_MESSAGE));
        return resultDirection.get();
    }

    public static Direction getDirectionByString(String direction) {
        Optional<Direction> resultDirection = Arrays.stream(Direction.values())
                .filter(dir -> dir.getDirectionString() == direction)
                .findAny();
        resultDirection.orElseThrow(() -> new IllegalArgumentException(INVALID_STRING_ERROR_MESSAGE));
        return resultDirection.get();
    }

}
