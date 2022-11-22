package bridge.view;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_LENGTH;

import bridge.bridge.BridgePosition;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final int BRIDGE_LOWER_INCLUSIVE = 3;
    public static final int BRIDGE_UPPER_INCLUSIVE = 20;

    public int readBridgeSize() throws IllegalArgumentException {
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_BRIDGE_LENGTH.getMessage());
        }
    }

    private void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (BRIDGE_LOWER_INCLUSIVE > bridgeSize || bridgeSize > BRIDGE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ILLEGAL_BRIDGE_LENGTH.getMessage());
        }
    }

    public BridgePosition readMoving() throws IllegalArgumentException {
        String moving = Console.readLine();
        return BridgePosition.fromString(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
