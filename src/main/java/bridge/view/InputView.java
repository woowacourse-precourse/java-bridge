package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ErrorMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final static String bridgeSizePattern = "^\\d*$";
    private final static String movingPattern = "^[A-Z]$";
    private final static String commandPattern = "^[A-Z]$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        if (!bridgeSize.matches(bridgeSizePattern)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.message);
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if (!move.matches(movingPattern)) {
            throw new IllegalArgumentException(INVALID_MOVING.message);
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        if (!gameCommand.matches(commandPattern)) {
            throw new IllegalArgumentException(INVALID_RETRY.message);
        }
        return gameCommand;
    }
}
