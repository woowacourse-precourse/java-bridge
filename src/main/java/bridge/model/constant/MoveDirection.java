package bridge.model.constant;

import java.util.Arrays;

public enum MoveDirection {
    UP("U", 1), DOWN("D", 0);

    private final String directionString;
    private final int directionNumber;

    MoveDirection(String directionString, int directionNumber) {
        this.directionString = directionString;
        this.directionNumber = directionNumber;
    }

    public String getDirectionString() {
        return directionString;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public static MoveDirection getMatchDirection(String directionString) {
        return Arrays.stream(MoveDirection.values()).filter((choice) -> choice.directionString.equals(directionString))
                .findAny().get();
    }

    public static MoveDirection getMatchDirection(int directionNumber) {
        return Arrays.stream(MoveDirection.values()).filter((choice) -> choice.directionNumber == directionNumber)
                .findAny().get();
    }
}
