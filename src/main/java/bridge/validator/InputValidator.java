package bridge.validator;

public class InputValidator {

    public void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }
}
