package bridge.model;

import bridge.util.BridgeGameExceptionMessage;
import java.util.Arrays;

public enum Direction {
    UP("U", 1), DOWN("D", 0);

    private final String command;
    private final int randomValue;

    Direction(String command, int randomValue) {
        this.command = command;
        this.randomValue = randomValue;
    }

    public static Direction fromInput(String input) {
        return Arrays.stream(values())
                .filter(direction -> direction.getCommand().equals(input))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.DIRECTION_NOT_MATCH.getMessage()));
    }

    public static Direction findDirectionByRandomValue(int randomValue) {
        return Arrays.stream(values())
                .filter(movingType -> movingType.randomValue == randomValue)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.RANDOM_NUMBER_NOT_MATCH.getMessage()));
    }

    public String getCommand() {
        return command;
    }
}
