package bridge.util;

import bridge.domain.Bridge;

public class BridgeLengthValidator {

    public static void validateLength(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(Message.LENGTH_ERROR.getMessage());
        }
        int length = Integer.parseInt(input);
        if(length < Bridge.minBound || length > Bridge.maxBound) {
            throw new IllegalArgumentException(Message.LENGTH_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }
}
