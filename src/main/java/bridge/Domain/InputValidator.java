package bridge.Domain;

import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String EMPTY_INPUT =  ERROR_PREFIX + "빈 문자입니다.";
    private static final String WRONG_SIZE_INPUT = ERROR_PREFIX + "숫자만 입력 가능합니다.";
    private static final String WRONG_SELECTION_INPUT = ERROR_PREFIX + "'U' 또는 'D'만 입력 가능합니다.";
    private static final String SELECTION_UP = "U";
    private static final String SELECTION_DOWN = "D";

    public static void validateNumberInput(String input) throws IllegalArgumentException {
        final String NOT_NUMBER_REGEX = "[^0-9]";

        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        if (input.matches(NOT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(WRONG_SIZE_INPUT);
        }
    }

    public static void validateSelectionInput(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }

        if (!input.equals(SELECTION_UP) && !input.equals(SELECTION_DOWN)) {
            throw new IllegalArgumentException(WRONG_SELECTION_INPUT);
        }
    }

}
