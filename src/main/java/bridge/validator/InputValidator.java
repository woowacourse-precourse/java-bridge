package bridge.validator;

import static bridge.constant.ExceptionConstants.*;

public class InputValidator {

    public static int validateBridgeSize(String input) {
        if (isInputEmpty(input) || !isNumber(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        if (!isSizeThreeToTwenty(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        return Integer.parseInt(input);
    }

    private static boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isSizeThreeToTwenty(String input) {
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize >= 3 && bridgeSize <= 20;
    }

    public static String validateMoving(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
        return input;
    }

    public static String validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
        return input;
    }
}
