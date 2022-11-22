package bridge;

public class Exception {
    private static final String regExp = "^[0-9]+$";


    public static void validateIsNumeric(String input) {
        ErrorMessage errorMessage = ErrorMessage.NOT_NUMERIC_VALUE;
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
