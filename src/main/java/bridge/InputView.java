package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String NOT_DIGITED_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private static final String NOT_IN_RANGED_BRIDGE_SIZE = "[ERROR] 다리 길이는 " + MIN_RANGE + "부터 " + MAX_RANGE + " 사이의 숫자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        validateDigitedBridgeSize(bridgeSize);
        validateInRangedBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private void validateDigitedBridgeSize(String bridgeSize) {
        for (int index = 0; index < bridgeSize.length(); index++) {
            if (!Character.isDigit(bridgeSize.charAt(index))) {
                throw new IllegalArgumentException(NOT_DIGITED_BRIDGE_SIZE_MESSAGE);
            }
        }
    }

    private void validateInRangedBridgeSize(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < MIN_RANGE || MAX_RANGE < Integer.parseInt(bridgeSize)) {
            throw new IllegalArgumentException(NOT_IN_RANGED_BRIDGE_SIZE);
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
