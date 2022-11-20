package bridge.valid;

import bridge.type.ErrorType;

public class Validation {

    public static void inputNumberValid(String number) {
        int convertNumber = 0;
        try {
            convertNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INPUT_BRIDGE_SIZE_ERROR_TYPE.getText());
        }

        if (convertNumber < 1 || convertNumber > 20) {
            throw new IllegalArgumentException(ErrorType.INPUT_BRIDGE_SIZE_ERROR_TYPE.getText());
        }
    }

    public static void inputMoveSquareValid(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException(ErrorType.INPUT_SQUARE_ERROR_TYPE.getText());
        }
    }

    public static void inputResumeCommandValid(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(ErrorType.INPUT_RESUME_COMMAND_ERROR_TYPE.getText());
        }
    }
}
