package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_OUT_OF_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final int BRIDGE_SIZE_MIN_VALUE = 3;
    private static final int BRIDGE_SIZE_MAX_VALUE = 20;
    private static final String NEW_LINE = "\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GAME_START + NEW_LINE);
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
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

    private void validateBridgeSize(String bridgeSize) {
        if (isNotInBridgeSizeRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    private boolean isNotInBridgeSizeRange(int bridgeSize) {
        return bridgeSize < BRIDGE_SIZE_MIN_VALUE || bridgeSize > BRIDGE_SIZE_MAX_VALUE;
    }
}
