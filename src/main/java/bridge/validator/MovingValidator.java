package bridge.validator;

import bridge.domain.Key;
import bridge.view.OutputView;

public class MovingValidator {
    private static final String MOVING_ERROR_MESSAGE = "[ERROR] 이동은 U, D로만 가능합니다.";

    public static void validate(String input) {
        if (!input.equals(Key.UP.command()) && !input.equals(Key.DOWN.command())) {
            OutputView.printErrorMessage(MOVING_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

}
