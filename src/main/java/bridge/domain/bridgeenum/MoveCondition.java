package bridge.domain.bridgeenum;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MoveCondition {
    UPPER("U", 1),
    LOWER("D", 0);

    private static final Map<Integer, String> POSITION_VALUE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(MoveCondition::getValue, MoveCondition::getposition));
    private final String position;
    private final int value;

    MoveCondition(String position, int value) {
        this.position = position;
        this.value = value;
    }

    public String getposition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public static String getMatchingMovePosition(int value) {
        return POSITION_VALUE_MAP.get(value);
    }
}
