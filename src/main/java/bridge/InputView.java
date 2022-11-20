package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리길이는 숫자여야합니다.");
        }
        if (!isInRange(input, MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리길이는 3부터 20사이의 숫자여야합니다.");
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
        int number = Integer.parseInt(input);
        return from <= number && number <= to;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();

        validateMoving(input);

        return input;
    }

    private void validateMoving(String input) {
        if (!isUpOrDown(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "U또는 D로 입력하여야합니다.");
        }
    }

    private boolean isUpOrDown(String input) {
        return input == "U" || input == "D";
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
