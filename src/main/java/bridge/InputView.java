package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Constant.MAX_BRIDGE_LENGTH;
import static bridge.Constant.MIN_BRIDGE_LENGTH;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        int bridgeSize;
        bridgeSize = checkNumeralInput(bridgeSizeInput);
        isValidBridgeSize(bridgeSize);

        return bridgeSize;
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

    private int checkNumeralInput(String bridgeSizeInput) {
        try {
            return Integer.parseInt(bridgeSizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자가 입력되어야 합니다.");
        }
    }

    private void isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_LENGTH || bridgeSize > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
