package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final int requestNewInput = -1;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String bridgeSizeInput) {
        try {
            int bridgeSize = validateBridgeSizeType(bridgeSizeInput);
            validateBridgeSizeRange(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(Error.ERROR_BRIDGE_LENGTH.getErrorMessage());
            return requestNewInput;
        }
    }

    public int validateBridgeSizeType(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalStateException();
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
