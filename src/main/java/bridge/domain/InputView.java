package bridge.domain;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String inputBridgeSize) {
        validateInputBridgeSize(inputBridgeSize);
        return Integer.valueOf(inputBridgeSize);
    }

    private void validateInputBridgeSize(String inputBridgeSize) {
        final String errorMsg = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
        if (inputBridgeSize.isEmpty() || inputBridgeSize.length() > 2) {
            throw new IllegalArgumentException(errorMsg);
        }
        if (inputBridgeSize.length() == 2 && !Character.isDigit(inputBridgeSize.charAt(1))) {
            throw new IllegalArgumentException(errorMsg);
        }
        if (!Character.isDigit(inputBridgeSize.charAt(0)) || !inRange(inputBridgeSize)) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private boolean inRange(String inputBridgeSize) {
        return Integer.valueOf(inputBridgeSize) >= 3 && Integer.valueOf(inputBridgeSize) <= 20;
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
