package bridge.validator;

public class InputValidator {

    public static void isDigit(final String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void isInBoundary(final String input) {
        int length = Integer.parseInt(input);

        if (length < 3 || length > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20 이하의 숫자만 가능합니다.");
        }
    }
}
