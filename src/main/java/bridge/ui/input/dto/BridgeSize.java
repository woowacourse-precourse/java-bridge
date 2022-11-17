package bridge.ui.input.dto;

import java.util.regex.Pattern;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static BridgeSize from(String userInput) {
        validate(userInput);
        return new BridgeSize(Integer.parseInt(userInput));
    }

    private static void validate(String userInput) {
        String bridgeSizeRegex = "^(1?[1-9]|[1-2]0)$";

        if (!Pattern.matches(bridgeSizeRegex, userInput)) {
            throw new IllegalArgumentException();
        }
    }
}
