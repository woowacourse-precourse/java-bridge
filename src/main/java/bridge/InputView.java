package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String UP = "U";
    public static final String DOWN = "D";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return validateBridgeSize(parseInt(Console.readLine()));
    }

    private int parseInt(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return result;
    }

    private int validateBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return validateMoving(Console.readLine());
    }

    private String validateMoving(String moving) {
        if (!moving.equals(UP) && !moving.equals(DOWN)) {
            throw new IllegalArgumentException();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
