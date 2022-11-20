package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();

        validateBridgeSize(input);

        return Integer.parseInt(input);
    }

    private void validateBridgeSize(String input) {
        if (!isDecimal(input)) {
            throw new IllegalArgumentException();
        }
        if (!isInRange(input, MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDecimal(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInRange(String input, int from, int to) {
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    private void validateMoving() {

    }

    private boolean isUpOrDown() {
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        return true;
    }

    private void validateGameCommand() {

    }

    private boolean isRetryOrQuit() {
        return true;
    }
}
