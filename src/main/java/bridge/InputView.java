package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readValue() {
        return Console.readLine();
    }

    private int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력하신 값은 정수가 아닙니다.");
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = convertToInteger(readValue());
        if (bridgeSize < BridgeRule.MIN_LENGTH.getValue() && bridgeSize > BridgeRule.MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하여야 합니다!");
        }
        return 0;
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
