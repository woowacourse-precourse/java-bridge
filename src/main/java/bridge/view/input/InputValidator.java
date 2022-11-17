package bridge.view.input;

import static java.lang.Integer.parseInt;

public class InputValidator {
    private static final String IS_NOT_NUMBER = "문자열이 아닌 숫자(정수)를 입력해주세요.";
    private static final String BRIDGE_SIZE_IS_NOT_IN_RANGE = "다리의 길이는 3부터 20사이의 숫자를 입력해주세요.";

    public void validateBridegeSize(String bridgeSize) {
        if (bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
        if (parseInt(bridgeSize) < 3 || parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_NOT_IN_RANGE);
        }
    }
}
