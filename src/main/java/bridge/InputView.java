package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public final String NUMBER_TYPE_ERROR = "숫자를 입력해주세요.";
    public final String BRIDGE_SIZE_RANGE_ERROR = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public final String MOVE_INPUT_ERROR = "U 또는 D를 입력해주세요.";
    public final String RETRY_INPUT_ERROR = "R 또는 Q를 입력해주세요.";


    private final static String UP = "U";
    private final static String DOWN = "D";
    private final static String RETRY = "R";
    private final static String EXIT = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR);
        }
    }

    public void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String selectedSpace = Console.readLine();
        validateMovingInput(selectedSpace);
        return selectedSpace;
    }

    public void validateMovingInput(String selectedSpace) {
        if (!selectedSpace.equals(UP) && !selectedSpace.equals(DOWN)) {
            throw new IllegalArgumentException(MOVE_INPUT_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String selectedRetry = Console.readLine();
        validateGameCommand(selectedRetry);
        return selectedRetry;
    }

    public void validateGameCommand(String selectedRetry) {
        if (!selectedRetry.equals(RETRY) && !selectedRetry.equals(EXIT)) {
            throw new IllegalArgumentException(RETRY_INPUT_ERROR);
        }
    }
}
