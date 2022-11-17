package bridge.view;

import bridge.domain.ErrorMessage;
import bridge.domain.UserKeySet;
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

        if (!userInput.matches(NUMERIC_PATTERN)) {
            String errorMsg = ErrorMessage.BRIDGE_SIZE_IS_NOT_NUMERIC.toString();
            throw new IllegalArgumentException(errorMsg);
        }

        int size = Integer.parseInt(userInput);

        if (size < minSize || size > maxSize) {
            String errorMsg = String.format(ErrorMessage.OUT_OF_BRIDGE_SIZE_RANGE.toString(), minSize, maxSize);
            throw new IllegalArgumentException(errorMsg);
        }

        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String userInput = Console.readLine();
        userInput = userInput.trim();

        if (!userInput.equals(UserKeySet.UP.toString()) && !userInput.equals(UserKeySet.DOWN.toString())) {
            String errorMsg = String.format(ErrorMessage.WRONG_MOVING_DIRECTION.toString(), UserKeySet.UP, UserKeySet.DOWN);
            throw new IllegalArgumentException(errorMsg);
        }

        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String userInput = Console.readLine();
        userInput = userInput.trim();

        if (!userInput.equals(UserKeySet.RETRY.toString()) && !userInput.equals(UserKeySet.QUIT.toString())) {
            String errorMsg = String.format(ErrorMessage.WRONG_MOVING_DIRECTION.toString(), UserKeySet.RETRY, UserKeySet.QUIT);
            throw new IllegalArgumentException(errorMsg);
        }

        return userInput;
    }
}
