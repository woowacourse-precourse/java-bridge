package bridge.Utils.Validation;

import bridge.Utils.ExceptionType;

public class ValidationForOneUpperAlphabet {

    public void check(String target) {
        isOnlyAlphabets(target);
        isOneAlphabet(target);
        isUpperAlphabet(target);
    }

    private void isOnlyAlphabets(String target) {
        String alphabetsRegex = "^[a-zA-Z]*$";
        if (!target.matches(alphabetsRegex)) {
            throw new IllegalArgumentException(ExceptionType.NOT_ONLY_ALPHABET.getMessage());
        }
    }

    private void isOneAlphabet(String target) {
        String oneAlphabetRegex = "^[a-zA-Z]$";
        if (!target.matches(oneAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.NOT_ONE_ALPHABET.getMessage());
        }
    }

    private void isUpperAlphabet(String target) {
        String upperAlphabetRegex = "^[A-Z]$";
        if (!target.matches(upperAlphabetRegex)) {
            throw new IllegalArgumentException(ExceptionType.NOT_UPPER_ALPHABET.getMessage());
        }
    }
}
