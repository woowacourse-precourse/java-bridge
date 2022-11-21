package bridge.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BridgeDirection {
    DOWN(0, "D"),
    UP(1, "U");

    private final int directionNumber;
    private final String direction;

    private BridgeDirection(int directionNumber, String direction) {
        this.directionNumber = directionNumber;
        this.direction = direction;
    }

    public static String getDirection(int directionNumber) {
        return Arrays.stream(values())
                .filter(BridgeDirection -> BridgeDirection.directionNumber == directionNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 0과 1외의 무작위 값이 발생하였습니다 "))
                .direction;
    }

    public static int getDirectionNumber(String direction) {
        return Arrays.stream(values())
                .filter(BridgeDirection -> BridgeDirection.direction.equals(direction))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 0과 1외의 무작위 값이 발생하였습니다 "))
                .directionNumber;
    }

    public static int getBridgeDirectionSize() {
        return (int) Arrays.stream(values()).count();
    }
}