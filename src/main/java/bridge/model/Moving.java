package bridge.model;

import bridge.util.BridgeGameExceptionMessage;
import java.util.Arrays;

public enum Moving {
    UP("U", 1), DOWN("D", 0);

    private final String direction;
    private final int randomValue;

    Moving(String direction, int randomValue) {
        this.direction = direction;
        this.randomValue = randomValue;
    }

    public static Moving fromInput(String inputDirection) {
        return Arrays.stream(values())
                .filter(moving -> moving.direction.equals(inputDirection))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.DIRECTION_NOT_MATCH.getMessage()));
    }

    public static Moving findDirectionByRandomValue(int randomValue) {
        return Arrays.stream(values())
                .filter(moving -> moving.randomValue == randomValue)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.RANDOM_NUMBER_NOT_MATCH.getMessage()));
    }

    public String getDirection() {
        return direction;
    }
}
