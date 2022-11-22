package bridge.util;

import bridge.domain.Bridge;
import bridge.view.OutputView;

public class BridgeLengthValidator {

    public static void validateLength(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(OutputView.LENGTH_ERROR_MESSAGE);
        }
        int length = Integer.parseInt(input);
        if(length < Bridge.minBound || length > Bridge.maxBound) {
            throw new IllegalArgumentException(OutputView.LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }
}
