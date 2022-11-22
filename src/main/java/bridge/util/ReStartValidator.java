package bridge.util;

import bridge.view.OutputView;

public class ReStartValidator {

    private static final char RESTART = 'R';
    private static final char EXIT = 'Q';
    private static final int LENGTH = 1;

    public static void validateReStarting(String input) {
        if (input.charAt(0) != LENGTH) {
            throw new IllegalArgumentException(OutputView.RESTART_ERROR_MESSAGE);
        }
        if (input.charAt(0) != RESTART && input.charAt(0) != EXIT) {
            throw new IllegalArgumentException(OutputView.RESTART_ERROR_MESSAGE);
        }
    }
}
