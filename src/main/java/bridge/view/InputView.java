package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.config.BridgeGameCommand.*;
import static bridge.config.BridgeGameConfig.BRIDGE_LENGTH_MAX;
import static bridge.config.BridgeGameConfig.BRIDGE_LENGTH_MIN;
import static bridge.view.message.exception.ExceptionMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return readValidatedSize(false);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return readValidatedMoving(false);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return readValidatedCommand(false);
    }

    private int readValidatedSize(boolean isValid) {
        int bridgeSize = 0;
        while (!isValid) {
            try {
                bridgeSize = Integer.parseInt(Console.readLine());
                isValid = validateBridgeSize(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_WRONG_LENGTH);
            }
        }
        return bridgeSize;
    }

    private String readValidatedCommand(boolean isValid) {
        String inputCommand = "";
        while (!isValid) {
            try {
                inputCommand = Console.readLine();
                isValid = validateGameCommand(inputCommand);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_WRONG_COMMAND);
            }
        }
        return inputCommand;
    }

    private String readValidatedMoving(boolean isValid) {
        String inputMoving = "";
        while (!isValid) {
            try {
                inputMoving = Console.readLine();
                isValid = validateMoving(inputMoving);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_WRONG_MOVING);
            }
        }
        return inputMoving;
    }

    private boolean validateBridgeSize(int size) {
        if (BRIDGE_LENGTH_MIN <= size && size <= BRIDGE_LENGTH_MAX) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean validateMoving(String inputMoving) {
        if (inputMoving.equals(COMMAND_BRIDGE_UP) || inputMoving.equals(COMMAND_BRIDGE_DOWN)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean validateGameCommand(String inputCommand) {
        if (inputCommand.equals(COMMAND_GAME_RETRY) || inputCommand.equals(COMMAND_GAME_QUIT)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
