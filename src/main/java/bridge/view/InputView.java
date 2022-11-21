package bridge.view;

import bridge.enums.InputMessage;
import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends InputException {
    private final String INITIAL_VALUE = "";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = INITIAL_VALUE;
        try {
            System.out.println(InputMessage.INPUT_BRIDGE_SIZE.getMessage());
            bridgeSize = Console.readLine();
            validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = INITIAL_VALUE;
        try {
            System.out.println(InputMessage.INPUT_PLAYER_MOVING.getMessage());
            moving = Console.readLine();
            validateMoving(moving);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = INITIAL_VALUE;
        try {
            System.out.println(InputMessage.INPUT_RESTART_OR_QUIT.getMessage());
            gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            return readGameCommand();
        }
        return gameCommand;
    }
}
