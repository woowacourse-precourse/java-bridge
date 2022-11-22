package bridge.util;

import bridge.view.OutputView;

public class MovingValidator {

    private static final int LENGTH = 1;
    private static final char UP = 'U';
    private static final char DOWN = 'D';

    public static void validateMoving(String input) {
        if(input.charAt(0) != LENGTH) {
            throw new IllegalArgumentException(OutputView.MOVING_ERROR_MESSAGE);
        }

        char command = input.charAt(0);
        if(command != UP && command != DOWN) {
            throw new IllegalArgumentException(OutputView.MOVING_ERROR_MESSAGE);
        }
    }
}
