package bridge;

public class validator {

    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

}
