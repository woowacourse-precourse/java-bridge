package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final int MIN_BRIDGE_SIZE_RANGE = 3;
    public static final int MAX_BRIDGE_SIZE_RANGE = 20;

    private static final String ERR_BRIDGE_SIZE_IS_NUMBER = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    public static final String ERR_BRIDGE_SIZE_RANGE = "[ERROR] 다리의 길이는 최소 3이상 최대 20이하입니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
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

    private int validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE_RANGE || MAX_BRIDGE_SIZE_RANGE < bridgeSize) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_RANGE);
        }
        return bridgeSize;
    }

    private int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_IS_NUMBER);
        }
    }
}
