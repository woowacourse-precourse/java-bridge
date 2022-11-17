package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeLength readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);

        return new BridgeLength(convertToInt(Console.readLine()));
    }

    private int convertToInt(String input) {
        canConvertInt(input);

        return Integer.parseInt(input);
    }

    private void canConvertInt(String string) {
        if (!isAllDigit(string)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllDigit(String string) {
        return string.chars()
                .allMatch(Character::isDigit);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
