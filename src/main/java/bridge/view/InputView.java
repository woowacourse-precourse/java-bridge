package bridge.view;

import static bridge.util.BridgeConstant.ERROR_PREFIX;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;
    public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printInputMessage(INPUT_BRIDGE_SIZE_MESSAGE);
        return getBridgeSize();
    }

    private int getBridgeSize() {
        String readBridgeSize = Console.readLine();
        while (true) {
            try {
                validateBridgeSize(readBridgeSize);
                return Integer.parseInt(readBridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
                readBridgeSize = Console.readLine();
            }
        }
    }

    private void validateBridgeSize(String readBridgeSize) {
        validateBridgeSizeIsNumber(readBridgeSize);
        validateBridgeSizeRange(readBridgeSize);
    }

    private void validateBridgeSizeIsNumber(String readBridgeSize) {
        try {
            Integer.parseInt(readBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
    }

    private void validateBridgeSizeRange(String readBridgeSize) {
        if (!validBridgeSize(Integer.parseInt(readBridgeSize))) {
            throw new IllegalArgumentException("3 이상 20 이하의 정수를 입력해야 합니다.");
        }
    }

    private boolean validBridgeSize(int readBridgeSize) {
        return MINIMUM_BRIDGE_SIZE <= readBridgeSize && readBridgeSize <= MAXIMUM_BRIDGE_SIZE;
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

    private void printInputMessage(String message) {
        System.out.println(message);
    }
}
