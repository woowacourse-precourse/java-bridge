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
        return Command.isSame(Command.UP, alphabet);
    }

    public boolean isDown() {
        return Command.isSame(Command.DOWN, alphabet);
    }

    public boolean isRetry() {
        return Command.isSame(Command.RETRY, alphabet);
    }

    public boolean isQuit() {
        return Command.isSame(Command.QUIT, alphabet);
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

    private enum Command {
        UP("U"),
        DOWN("D"),
        RETRY("R"),
        QUIT("Q");

        private final String letter;

        Command(String letter) {
            this.letter = letter;
        }

        private static boolean isSame(Command command, String input) {
            return input.equals(command.letter);
        }
    }
}
