package bridge;

import java.util.regex.Pattern;

public class InputViewValidate {
    private static final String sizePattern = "^[0-9]+$";
    private static final String movePattern = "^[U|D]";
    private static final String commandPattern = "^[R|Q]";

    public static void inputSizeValidate(String inputSize) {
        if (!(Pattern.matches(sizePattern, inputSize))) {
            throw new IllegalArgumentException(Message.INPUT_IS_NOT_NUMBER);
        }
    }

    public static void sizeValidate(int size) {
        if (size < Message.MIN_BRIDGE_SIZE || size > Message.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Message.INPUT_CORRECT_RANGE_OF_NUMBER);
        }
    }

    public static void inputMoveValidate(String inputMove) {
        if (!(Pattern.matches(movePattern, inputMove))) {
            throw new IllegalArgumentException(Message.INPUT_U_OR_D);
        }
    }

    public static void inputCommandValidate(String inputCommand) {
        if (!(Pattern.matches(commandPattern, inputCommand))) {
            throw new IllegalArgumentException(Message.INPUT_R_OR_Q);
        }
    }
}
