package bridge.view.validation;

import bridge.vo.ErrorMessage;

public class InputRestartValidator {

    public static void validate(String input) {
        if(inputIsNotRAndIsNotQ(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_R_AND_NOT_Q_MESSAGE.toString());
        }
    }

    private static boolean inputIsNotRAndIsNotQ(String input) {
        return !(input.equals("R") || input.equals("Q"));
    }
}
