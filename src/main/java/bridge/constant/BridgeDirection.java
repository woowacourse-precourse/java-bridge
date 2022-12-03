package bridge.constant;

import java.util.Arrays;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final Integer direction;
    private final String firstLetter;

    BridgeDirection(Integer direction, String firstLetter) {
        this.direction = direction;
        this.firstLetter = firstLetter;
    }

    public static String convertToString(Integer direction) {
        if (direction == UP.direction) {
            return UP.firstLetter;
        }
        return DOWN.firstLetter;
    }

    public static void validateInputDirection(String input) {
        boolean match = Arrays.stream(BridgeDirection.values())
                .anyMatch(direction -> direction.firstLetter.equals(input));
        if (!match) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_IS_INCORRECT.getMessage());
        }
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
