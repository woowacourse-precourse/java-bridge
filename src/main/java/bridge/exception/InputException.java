package bridge.exception;

import bridge.constant.message.ErrorMessage;

public class InputException {

    private static StringBuilder sb;

    public static int validateInputLength(String size) {
        sb = new StringBuilder(ErrorMessage.NOTICE.getMessage());
        if (!isNumeric(size) || !(3 <= Integer.parseInt(size) && Integer.parseInt(size) <= 20)) {
            sb.append(ErrorMessage.ERROR_INPUT_LENGTH_RANGE.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
        return Integer.parseInt(size);
    }

    public static String validateInputMoveCommand(String command) {
        sb = new StringBuilder(ErrorMessage.NOTICE.getMessage());
        if (!(command.equals("U") || command.equals("D"))) {
            sb.append(ErrorMessage.ERROR_INPUT_MOVE_RANGE.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
        return command;
    }

    public static String validateInputRetryCommand(String command) {
        sb = new StringBuilder(ErrorMessage.NOTICE.getMessage());
        if (!(command.equals("R") || command.equals("Q"))) {
            sb.append(ErrorMessage.ERROR_INPUT_END_RANGE.getMessage());
            throw new IllegalArgumentException(sb.toString());
        }
        return command;
    }

    public static boolean isNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) return false;
        return true;
    }
}
