package bridge.view.validation;

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
        if (!(input.equals("R") || input.equals("Q"))) {
            System.out.println(ERROR_RETRY_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
