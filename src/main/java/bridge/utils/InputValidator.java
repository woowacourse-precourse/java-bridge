package bridge.utils;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateBridgeSizeInput(String bridgeSizeInputValue) {

        validateBridgeSizeType(bridgeSizeInputValue);
        validateBridgeSizeRange(convertToIntBridgeSize(bridgeSizeInputValue));
    }

    public static void validatePlayerMovingInput(String moving) {
        isMovingInputUOrD(moving);
    }

    public static void validateGameCommandInput(String commandInput) {
        isCommandInputValidation(commandInput);
    }

    private static void validateBridgeSizeType(String bridgeSize) {
        String bridgeTypeRegex = "^[1-9][0-9]?$";
        if (!bridgeSize.matches(bridgeTypeRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private static int convertToIntBridgeSize(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

    private static void validateBridgeSizeRange(int bridgeSize) {
        if (BridgeSizeRange.validateBridgeSizeRange(bridgeSize)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isMovingInputUOrD(String moving) {
        String movingRegex = "[UD]";
        if (!moving.matches(movingRegex)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isCommandInputValidation(String command) {
        String commandRegex = "[RQ]";
        if (!command.matches(commandRegex)) {
            throw new IllegalArgumentException();
        }
    }
}
