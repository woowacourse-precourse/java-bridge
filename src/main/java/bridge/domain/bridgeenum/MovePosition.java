package bridge.domain.bridgeenum;

import bridge.domain.errorenum.ErrorMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MovePosition {
    UPPER("U", 1),
    LOWER("D", 0);

    private static final Map<Integer, String> POSITION_VALUE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(MovePosition::getValue, MovePosition::getPosition));
    private final String position;
    private final int value;

    MovePosition(String position, int value) {
        this.position = position;
        this.value = value;
    }

    public static String getMatchingMovePosition(int value) {
        return POSITION_VALUE_MAP.get(value);
    }

    public static void validateNextMove(String inputPosition) {
        Arrays.stream(values())
                .filter(condition -> condition.hasPosition(inputPosition))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_IN_MOVE_POSITION.printMessage()));
    }

    public String getPosition() {
        return position;
    }

    private int getValue() {
        return value;
    }

    private boolean hasPosition(String position) {
        return this.position.equals(position);
    }
}
