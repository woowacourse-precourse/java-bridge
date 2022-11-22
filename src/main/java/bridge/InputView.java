package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_SELECT_BLOCK = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ENTER_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    private static final String ERROR_MESSAGE_SIZE_RANGE = "[ERROR] 3이상 20이하로 입력해주세요.";
    private static final String ERROR_MESSAGE_MOVING_BLOCK = "[ERROR] 올바른 값을 입력해주세요. (위: U, 아래: D)";
    private static final String ERROR_MESSAGE_RETRY_GAME = "[ERROR] 올바른 값을 입력해주세요. (재시도: R, 종료: Q)";

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

    public String getMoving() {
        OutputView.printMessage(ENTER_SELECT_BLOCK);
        String result = readMoving(Console.readLine());
        while (result == null) {
            result = readMoving(Console.readLine());
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String enterValue) {
        try {
            isValidMoving(enterValue);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return null;
        }
        return enterValue;
    }

    private void isValidMoving(String str) {
        if (!(str.equals("U") || str.equals("D"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MOVING_BLOCK);
        }
    }

    public String getGameCommand() {
        OutputView.printMessage(ENTER_RETRY_COMMAND);
        String result = readGameCommand(Console.readLine());
        while (result == null) {
            result = readGameCommand(Console.readLine());
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String enterValue) {
        try {
            isValidRetryCommand(enterValue);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return null;
        }
        return enterValue;
    }

    private void isValidRetryCommand(String str) {
        if (!(str.equals("R") || str.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RETRY_GAME);
        }
    }
}
