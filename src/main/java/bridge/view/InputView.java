package bridge.view;

import static bridge.utils.ErrorConstants.ERROR_NOT_NUMBER;
import static bridge.utils.ErrorConstants.ERROR_OUT_OF_BRIDGE_RANGE;
import static bridge.utils.ErrorConstants.ERROR_NOT_U_OR_D;
import static bridge.utils.ErrorConstants.ERROR_NOT_R_OR_Q;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = Console.readLine();
            validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void validateBridgeSize(String input) {
        validateIsNumber(input);
        validateBridgeSizeRange(Integer.parseInt(input));
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void validateBridgeSizeRange(int size) {
        if (!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_BRIDGE_RANGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String movingPath = Console.readLine();
            validateMovingPath(movingPath);
            return movingPath;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private static void validateMovingPath(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ERROR_NOT_U_OR_D);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String retryCommand = Console.readLine();
            validateRetryCommand(retryCommand);
            return retryCommand;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateRetryCommand(String retryCommand) {
        if (!(retryCommand.equals("R") || retryCommand.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_NOT_R_OR_Q);
        }
    }
}
