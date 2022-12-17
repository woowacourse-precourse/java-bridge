package bridge.view.validation;

import static bridge.utils.Command.QUIT;
import static bridge.utils.Command.RETRY;
import static bridge.view.Message.ERROR_RETRY_MESSAGE;

public class RetryValidation {

    public static boolean retryValidation(String input) {
        try {
            inNotValidation(input);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void inNotValidation(String input) {
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            System.out.println(ERROR_RETRY_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
