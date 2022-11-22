package bridge.validator;

import bridge.view.OutputView;

public class BridgeSizeValidator {
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자여야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 범위는 3 이상 20 이하여야 합니다.";

    public static void validate(String input) {
        validateNumber(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            OutputView.printErrorMessage(NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int size) {
        if (size < 3 || size > 20) {
            OutputView.printErrorMessage(RANGE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
