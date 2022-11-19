package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    private static final String ERROR_MESSAGE_SIZE_RANGE = "[ERROR] 3이상 20이하로 입력해주세요.";

    public int getBridgeSize() {
        OutputView.printMessage(ENTER_BRIDGE_SIZE);
        int result = readBridgeSize(Console.readLine());
        while (result == 0) {
            result = readBridgeSize(Console.readLine());
        }
        return result;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String enterValue) {
        try {
            isValidBridgeSize(enterValue);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return 0;
        }
        return Integer.parseInt(enterValue);
    }

    private void isValidBridgeSize(String str) {
        isNumber(str);
        if (Integer.parseInt(str) < 3 || Integer.parseInt(str) > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE_RANGE);
        }
    }

    private void isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER);
            }
        }
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
