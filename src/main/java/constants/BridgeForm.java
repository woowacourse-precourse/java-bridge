package constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeForm {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int value;

    BridgeForm(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return this.direction;
    }

    public int getValue() {
        return this.value;
    }

    private static final Map<Integer, String> BY_VALUE =
            Stream.of(values()).collect(Collectors.toMap(BridgeForm::getValue, BridgeForm::getDirection));

    public static String valueToDirection(int value) {
        return BY_VALUE.get(value);
    }
}
