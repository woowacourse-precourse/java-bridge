package bridge.exception;

public class InputValidator {
    private static final String ERROR = "[ERROR]";
    private static final String INVALID_BRIDGE_LENGTH_TYPE_MESSAGE = "숫자를 입력해주세요.";
    private static final String INVALID_MOVING_COMMAND_MESSAGE = "U 또는 D를 입력해주세요.";
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "3 이상 20 이하의 숫자를 입력해주세요.";
    private static final String INVALID_RETRY_COMMAND_MESSAGE = "R 또는 Q를 입력해주세요.";

    public static void validateBridgeLength(String length) {
        if (!isNumber(length)) {
            throw new IllegalArgumentException(ERROR + INVALID_BRIDGE_LENGTH_TYPE_MESSAGE);
        }
        int parsedNumber = Integer.parseInt(length);
        if ((parsedNumber < 3) || (parsedNumber > 20)) {
            throw new IllegalArgumentException(ERROR + INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void validateCorrectMovingCommand(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException(ERROR + INVALID_MOVING_COMMAND_MESSAGE);
        }
    }

    public static void validateCorrectRetryCommand(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(ERROR + INVALID_RETRY_COMMAND_MESSAGE);
        }
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
