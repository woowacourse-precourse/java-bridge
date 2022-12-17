package bridge.view.validation;

import static bridge.utils.Command.DOWN;
import static bridge.utils.Command.UP;
import static bridge.view.Message.ERROR_STATE_MESSAGE;

public class StateValidation {

    public static boolean stateValidation(String input) {
        try {
            inNotValidation(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void inNotValidation(String input) {
        if (!(input.equals(DOWN) || input.equals(UP))) {
            System.out.println(ERROR_STATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
