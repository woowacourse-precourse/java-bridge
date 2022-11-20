package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateNonBlank(bridgeSize);
        validateNumeric(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLANK_INPUT);
        }
    }

    private void validateNumeric(String input) {
        if (isNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_INPUT);
        }
    }

    private boolean isNonNumeric(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
