package bridge.model;

import bridge.util.BridgeGameExceptionMessage;
import java.util.Arrays;

public enum Direction {
    U(1), D(0);

    private final int randomValue;

    Direction(int randomValue) {
        this.randomValue = randomValue;
    }

    public static Direction fromInput(String input) {
        try {
            return valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(BridgeGameExceptionMessage.DIRECTION_NOT_MATCH.getMessage());
        }
    }

    public static Direction findDirectionByRandomValue(int randomValue) {
        return Arrays.stream(values())
                .filter(movingType -> movingType.randomValue == randomValue)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.RANDOM_NUMBER_NOT_MATCH.getMessage()));
    }
}
