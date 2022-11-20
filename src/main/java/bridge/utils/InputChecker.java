package bridge.utils;

import bridge.view.ExceptionMessage;

public class InputChecker {

    private static void nullCheck(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
