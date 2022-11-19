package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String BRIDGE_SIZE_INPUT_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";

    private static final String MOVING_INPUT_ERROR_MESSAGE = "[ERROR] U(위), D(아래) 중 하나를 입력해야 합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
        return getValidBridgeSize();
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

    public int getValidBridgeSize() {
        try {
            String input = Console.readLine();
            validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBridgeSize();
        }
    }

    public String getValidMoving() {
        try {
            String input = Console.readLine();
            validateMoving(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidMoving();
        }
    }

    public void validateBridgeSize(String input) throws IllegalArgumentException {
        checkParsableInt(input);
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateMoving(String input) throws IllegalArgumentException {
        List<String> movingOptions = List.of(UP_BRIDGE, DOWN_BRIDGE);
        if(!movingOptions.contains(input)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }

    private void checkParsableInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR_MESSAGE);
        }
    }
}
