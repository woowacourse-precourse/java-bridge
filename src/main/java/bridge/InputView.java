package bridge;

import static bridge.constant.Config.*;

import bridge.constant.command.DirectionCommand;
import bridge.constant.command.GameCommand;
import bridge.constant.message.InputErrorMessage;
import bridge.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String command = Console.readLine();
        checkNumericString(command);
        int bridgeSize = Integer.parseInt(command);
        checkRangeOfBridgeSize(bridgeSize);
        return bridgeSize;
    }

    private void checkNumericString(String command) {
        if (!Validator.isNumericString(command)) {
            throw new IllegalArgumentException(InputErrorMessage.NO_NUMERIC_STRING.getMessage());
        }
    }

    private void checkRangeOfBridgeSize(int bridgeSize) {
        if (!Validator.isInRangeOfNumber(bridgeSize, RANGE_OF_BRIDGE_SIZE_START, RANGE_OF_BRIDGE_SIZE_END)) {
            throw new IllegalArgumentException(InputErrorMessage.NO_RANGE_OF_BRIDGE_SIZE.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String command = Console.readLine();
        checkValidMoving(command);
        return command;
    }

    private void checkValidMoving(String command) {
        for (DirectionCommand directionCommand : DirectionCommand.values()) {
            if (directionCommand.getValue().equals(command)) {
                return;
            }
        }
        throw new IllegalArgumentException(InputErrorMessage.NO_VALID_MOVING.getMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        checkValidGameCommand(command);
        return command;
    }

    private void checkValidGameCommand(String command) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getValue().equals(command)) {
                return;
            }
        }
        throw new IllegalArgumentException(InputErrorMessage.NO_VALID_GAME_COMMAND.getMessage());
    }
}
