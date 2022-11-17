package bridge;

import java.util.Arrays;

public enum BridgeDirection {
    UP_NUMBER(0, "D"),
    DOWN_NUMBER(1, "U");

    private final int directionNumber;
    private final String direction;

    private BridgeDirection(int directionNumber, String direction) {
        this.directionNumber = directionNumber;
        this.direction = direction;
    }

    public static String getDirection(int directionNumber) {
        return Arrays.stream(values())
                .filter(BridgeDirection -> BridgeDirection.directionNumber == directionNumber)
                .findFirst().orElseThrow(()->new IllegalArgumentException("[ERROR] 0과 1외의 무작위 값이 발생하였습니다 "))
                .direction;
    }
}