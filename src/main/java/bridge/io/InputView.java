package bridge.io;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int INPUT_MINIMUM_VALUE = 3;
    private static final int INPUT_MAXIMUM_VALUE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());
        validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_NUMBER_ERROR_MESSAGE);
        }
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
        return Console.readLine();
    }
}
