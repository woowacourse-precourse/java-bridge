package bridge.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    D("D", 0),
    U("U", 1);

    private static final String INVALID_INTEGER_ERROR_MESSAGE = "[ERROR] 방향으로 전환 될 수 없는 숫자의 입력 입니다.";

    private String direction;
    private int directionNumber;

    Direction(String direction, int directionNumber) {
        this.direction = direction;
        this.directionNumber = directionNumber;
    }

    public String getDirection() {
        return direction;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public static String getDirectionStringByNumber(int directionNumber) {
        Optional<String> direction = Arrays.stream(Direction.values())
                .filter(dir -> dir.getDirectionNumber() == directionNumber)
                .map(dir -> dir.getDirection())
                .findAny();
        direction.orElseThrow(()->new IllegalArgumentException(INVALID_INTEGER_ERROR_MESSAGE));
        return direction.get();
    }

}
