package bridge.utils;

public class EmptyChecker {

    public static void check(final String input) {
        try {
            if (input.isBlank()) {
                throw new IllegalArgumentException("Input is null.");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Input is null.");
        }
    }
}
