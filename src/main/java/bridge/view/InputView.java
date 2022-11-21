package bridge.view;

import static bridge.view.ErrorMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.BridgeStatus;
import bridge.model.GameStatus;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = readLine();
        validateNumberType(bridgeSize);
        validateNumberRange(Integer.parseInt(bridgeSize));
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readLine();
        validateBridgeControlType(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = readLine();
        validateGameRetryType(command);
        return command;
    }

    private void validateNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_HEADER + VALIDATE_INTEGER_TYPE);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_HEADER + VALIDATE_BRIDGE_RANGE);
        }
    }

    private void validateBridgeControlType(String text) {
        if (!text.equals(BridgeStatus.UP.getCommand()) && !text.equals(BridgeStatus.DOWN.getCommand())) {
            throw new IllegalArgumentException(ERROR_HEADER + VALIDATE_BRIDGE_MOVE);
        }
    }

    private void validateGameRetryType(String text) {
        if (!text.equals(GameStatus.RETRY.getCommand()) && !text.equals(GameStatus.QUIT.getCommand())) {
            throw new IllegalArgumentException(ERROR_HEADER + VALIDATE_GAME_RETRY);
        }
    }
}
