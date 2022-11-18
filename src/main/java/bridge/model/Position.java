package bridge.model;

import java.util.Arrays;

public enum Position {

    UP("U", 1),
    DOWN("D", 0);

    private final String position;
    private final int generatedNumber;

    Position(String position, int generatedNumber) {
        this.position = position;
        this.generatedNumber = generatedNumber;
    }

    public static String numberToPosition(int generatedNumber) {
        return findPosition(generatedNumber).position;
    }

    private static Position findPosition(int generatedNumber) {
        return Arrays.stream(Position.values())
                .filter(position -> position.generatedNumber == generatedNumber)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
    }


}
