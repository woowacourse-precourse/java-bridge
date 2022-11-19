package bridge.ui.input.dto;

import bridge.ui.input.InputErrorText;
import java.util.regex.Pattern;

public class BridgeSize {
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private final String bridgeSize;

    public BridgeSize(String bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public static BridgeSize from(String userInput) {
        return new BridgeSize(userInput);
    }

    private void validate(String userInput) {
        validateNumber(userInput);
        validateRange(userInput);
    }

    private void validateNumber(String userInput) {
        String bridgeSizeRegex = "^([0-9]{1,2})$";

        if (!Pattern.matches(bridgeSizeRegex, userInput)) {
            throw new IllegalArgumentException(InputErrorText.ERROR_BRIDGE_NUMBER.errorText());
        }
    }

    private void validateRange(String userInput) {
        int bridgeSize = Integer.parseInt(userInput);
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(InputErrorText.ERROR_BRIDGE_SIZE.errorText());
        }
    }

    public int toInteger() {
        return Integer.parseInt(this.bridgeSize);
    }
}
