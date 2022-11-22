package bridge.utils.parser;

import bridge.domain.exception.EmptyInputException;

public class EmptyChecker {

    private EmptyChecker() {
    }

    public static void check(final String input) {
        if (isEmptyOrNull(input)) {
            throw new EmptyInputException();
        }
    }

    private static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }
}
