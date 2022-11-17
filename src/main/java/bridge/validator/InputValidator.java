package bridge.validator;

public class InputValidator {

    public void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    public void isInBoundary(String input) {
        int length = Integer.parseInt(input);

        if (length < 3 || length > 20) {
            throw new IllegalArgumentException("3이상 20 이하의 숫자만 가능합니다.");
        }
    }
}
