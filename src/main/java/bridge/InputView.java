package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_BRIDGE_LENGTH_NOT_NUMBER = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private static final String ERROR_BRIDGE_LENGTH_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String ERROR_MOVING_INPUT = "[ERROR] 이동할 칸은 U또는 D여야 합니다.";
    private static final int BRIDGE_RANGE_START = 3;
    private static final int BRIDGE_RANGE_END = 20;


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeLength = Console.readLine();
        return validateBridgeSize(bridgeLength);
    }

    //숫자이고 가능한 길이 인지 확인한다.
    public int validateBridgeSize(String bridgeLength) {
        int bridgeLen = StringToInteger(bridgeLength);
        if (BRIDGE_RANGE_START <= bridgeLen && bridgeLen <= BRIDGE_RANGE_END) {
            return bridgeLen;
        }
        throw new IllegalArgumentException(ERROR_BRIDGE_LENGTH_RANGE);
    }

    private int StringToInteger(String bridgeLength) {
        try {
            return Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BRIDGE_LENGTH_NOT_NUMBER);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String wantedDirection = Console.readLine();
        return validateMoving(wantedDirection);
    }

    private String validateMoving(String wantMoved) {
        if (wantMoved.equals("U") || wantMoved.equals("D")) {
            return wantMoved;
        }
        throw new IllegalArgumentException(ERROR_MOVING_INPUT);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
