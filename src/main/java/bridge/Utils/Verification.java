package bridge.Utils;

import bridge.View.OutputView;

public class Verification {

    private static boolean verify(final String input, final String value, final String error) {
        try {
            if (!input.matches(value)) {
                throw new IllegalArgumentException(error);
            }
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }
}
