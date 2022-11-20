package bridge.util;

import static bridge.util.Constants.ERROR_TITLE;
import static bridge.util.Constants.NON_ALPHABETIC_CHARACTER_FOUND;

import java.util.Arrays;

public class CapitalLetter {
    private static final String NO_SPACE = "";
    private static final String NON_ALPHABETIC_CHARACTER = "[^a-zA-Z]";

    private final String letter;

    public CapitalLetter(String letter) {
        validateAlphabeticType(letter);
        this.letter = letter;
    }

    public String capitalize() {
        return letter.toUpperCase();
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
            if (letter.equals(theOther.letter)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return letter.hashCode();
    }
}
