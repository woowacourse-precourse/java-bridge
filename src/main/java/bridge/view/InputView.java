package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int BRIDGE_MAXIMUM_SIZE = 20;
    private static final int BRIDGE_MINIMUM_SIZE = 3;

    public static int inputBridgeSize() {
        String bridgeSize = Console.readLine();
        validateSizeNumber(bridgeSize);
        validateSizeRange(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private static void validateSizeNumber(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(OutputMessage.BRIDGE_IS_NUMBER.getErrorMessage());
        }
    }

    private static void validateSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < BRIDGE_MINIMUM_SIZE ||
            Integer.parseInt(bridgeSize) > BRIDGE_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OutputMessage.BRIDGE_HAS_RANGE.getErrorMessage());
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
