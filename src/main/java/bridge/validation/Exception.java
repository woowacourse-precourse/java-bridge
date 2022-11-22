package bridge.validation;

import bridge.constant.ErrorMessage;

public class Exception {

    public static void checkSizeException(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) < 48 || (int) input.charAt(i) > 57) {
                throw new IllegalArgumentException(ErrorMessage.IS_NUMBER.message);
            }
        }
    }

    public static void checkRangeException(String input) {
        int size = Integer.parseInt(input);
        if (size < 3 || 19 < size) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCorrectInputUpDown(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_UP_DOWN.message);
        }
    }

    public static void checkCorrectInputQuitRestart(String input) {
        if (!(input.equals("Q") || input.equals("R"))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_QUIT_RESTART.message);
        }
    }

}
