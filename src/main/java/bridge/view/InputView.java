package bridge.view;

import bridge.model.ErrorMessage;
import bridge.model.UserKeySet;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMERIC_PATTERN = "^\\d*$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(int minSize, int maxSize) throws IllegalArgumentException {
        String userInput = Console.readLine();

        checkBridgeSizeNumericPattern(userInput);

        int size = Integer.parseInt(userInput);

        checkBridgeSizeRange(minSize, maxSize, size);

        return size;
    }

    private void checkBridgeSizeRange(int minSize, int maxSize, int size) throws IllegalArgumentException {
        if (size < minSize || size > maxSize) {
            String errorMsg = String.format(ErrorMessage.OUT_OF_BRIDGE_SIZE_RANGE.toString(), minSize, maxSize);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private void checkBridgeSizeNumericPattern(String userInput) throws IllegalArgumentException {
        if (!userInput.matches(NUMERIC_PATTERN)) {
            String errorMsg = ErrorMessage.BRIDGE_SIZE_IS_NOT_NUMERIC.toString();
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String userInput = Console.readLine();
        userInput = userInput.trim();

        checkMovingKey(userInput);

        return userInput;
    }

    private void checkMovingKey(String userInput) throws IllegalArgumentException {
        if (!userInput.equals(UserKeySet.UP.toString()) && !userInput.equals(UserKeySet.DOWN.toString())) {
            String errorMsg = String.format(ErrorMessage.WRONG_MOVING_DIRECTION.toString(), UserKeySet.UP, UserKeySet.DOWN);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String userInput = Console.readLine();
        userInput = userInput.trim();

        checkGameCommandKey(userInput);

        return userInput;
    }

    private void checkGameCommandKey(String userInput) throws IllegalArgumentException {
        if (!userInput.equals(UserKeySet.RETRY.toString()) && !userInput.equals(UserKeySet.QUIT.toString())) {
            String errorMsg = String.format(ErrorMessage.WRONG_MOVING_DIRECTION.toString(), UserKeySet.RETRY, UserKeySet.QUIT);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
