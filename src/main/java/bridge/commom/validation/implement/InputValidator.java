package bridge.commom.validation.implement;

public class InputValidator {
    public static void isPositiveInteger(String input) throws IllegalArgumentException {
        String exceptionMessage = "양의 정수만 입력할 수 있습니다.";
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(exceptionMessage);
        }

        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
