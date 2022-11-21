package bridge;

import java.util.stream.Stream;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String direction;

    BridgeDirection(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public int getNumber() {
        return number;
    }

    public String getDirection() {
        return direction;
    }

    public static BridgeDirection toBridgeDirection(int generatedNumber) {
        return Stream.of(BridgeDirection.values())
                .filter(direction -> direction.getNumber() == generatedNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
