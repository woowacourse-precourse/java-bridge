package bridge.validation;

import bridge.constant.ErrorMessage;

public class Exception {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int ASCII_MIN_NUMBER = 48;
    private static final int ASCII_MAX_NUMBER = 57;
    private static final String INPUT_UP_TO_JUDGE= "U";
    private static final String INPUT_DOWN_TO_JUDGE = "D";
    private static final String INPUT_QUIT_TO_JUDGE = "Q";
    private static final String INPUT_RESTART_TO_JUDGE = "R";

    public static void checkSizeException(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < ASCII_MIN_NUMBER || (int) input.charAt(i) > ASCII_MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.IS_NUMBER.message);
            }
        }
    }

    public static void checkRangeException(String input) {
        int size = Integer.parseInt(input);
        if (size < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < size) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCorrectInputUpDown(String input) {
        if (!(input.equals(INPUT_UP_TO_JUDGE) || input.equals(INPUT_DOWN_TO_JUDGE))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_UP_DOWN.message);
        }
    }

    public static void checkCorrectInputQuitRestart(String input) {
        if (!(input.equals(INPUT_QUIT_TO_JUDGE) || input.equals(INPUT_RESTART_TO_JUDGE))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_QUIT_RESTART.message);
        }
    }

}
