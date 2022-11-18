package bridge;

import static bridge.ErrorMessage.INVALID_BRIDGE_SIZE_ERROR;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Runnable printInputMessage) {
        printInputMessage.run();
        String bridgeSizeInput = readLine();
        validateBridgeSize(bridgeSizeInput);
        return Integer.valueOf(bridgeSizeInput);
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

    public void validateBridgeSize(String bridgeSizeInput) {
        final String IN_3_TO_20_PATTERN = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";

        if (!bridgeSizeInput.matches(IN_3_TO_20_PATTERN)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_ERROR);
        }
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
