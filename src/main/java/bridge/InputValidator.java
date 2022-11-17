package bridge;

import java.math.BigInteger;

public class InputValidator {
    private static final int MAX_INT_VALUE = 2_147_483_647;
    private static final String NUMBER = "[0-9]+";
    private final String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public boolean isEmptyOrBlank() {
        return input.isEmpty() || input.isBlank();
    }

    public boolean isNumber() {
        return input.matches(NUMBER);
    }

    public boolean isOutOfInt() {
        BigInteger number = new BigInteger(input);
        return number.compareTo(BigInteger.valueOf(MAX_INT_VALUE)) > 0;
    }
}
