package bridge;

import java.util.Arrays;
import java.util.stream.Collectors;

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
                .findFirst()
                .get()
                .direction;

    }
}
