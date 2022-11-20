package bridge.util;

import static bridge.util.Constants.ERROR_TITLE;
import static bridge.util.Constants.NON_ALPHABETIC_CHARACTER_FOUND;

import java.util.Arrays;

public class CapitalLetter {
    private static final String NO_SPACE = "";
    private static final String NON_ALPHABETIC_CHARACTER = "[^a-zA-Z]";

    private final String alphabet;

    public CapitalLetter(String alphabet) {
        validateAlphabeticType(alphabet);
        this.alphabet = alphabet.toUpperCase();
    }

    public boolean isUp() {
        return isSame(CommandKeys.UP, alphabet);
    }

    public boolean isDown() {
        return isSame(CommandKeys.DOWN, alphabet);
    }

    public boolean isRetry() {
        return isSame(CommandKeys.RETRY, alphabet);
    }

    public boolean isQuit() {
        return isSame(CommandKeys.QUIT, alphabet);
    }

    private static boolean isSame(CommandKeys commandKey, String input) {
        return commandKey.getLetter().equals(input);
    }

    private static void validateAlphabeticType(String input) {
        if (isNotAlphabetic(input)) {
            throw new IllegalArgumentException(ERROR_TITLE + NON_ALPHABETIC_CHARACTER_FOUND);
        }
    }

    private static boolean isNotAlphabetic(String input) {
        final String[] splitted = input.split(NO_SPACE);

        return Arrays.stream(splitted)
                .anyMatch(element ->
                        element.matches(NON_ALPHABETIC_CHARACTER)
                );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CapitalLetter) {
            CapitalLetter theOther = (CapitalLetter) obj;
            if (alphabet.equals(theOther.alphabet)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return alphabet.hashCode();
    }
}
