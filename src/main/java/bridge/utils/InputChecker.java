package bridge.utils;

public class InputChecker {

    public static void nullCheck(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
