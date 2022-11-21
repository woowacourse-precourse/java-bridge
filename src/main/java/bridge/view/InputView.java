package bridge.view;

import static bridge.constant.InputKeyConstant.DOWN;
import static bridge.constant.InputKeyConstant.QUIT;
import static bridge.constant.InputKeyConstant.RETRY;
import static bridge.constant.InputKeyConstant.UP;
import static bridge.constant.NumberConstant.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.NumberConstant.MINIMUM_BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.BRIDGE_SIZE;
import static bridge.exception.ExceptionHandler.INPUT_DIRECTION;
import static bridge.exception.ExceptionHandler.INPUT_GAME_COMMAND;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        int bridgeSize = 0;

        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
        } catch (NumberFormatException exception) {
            BRIDGE_SIZE.error();
        }

        return bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE.getCode() || bridgeSize > MAXIMUM_BRIDGE_SIZE.getCode()) {
            BRIDGE_SIZE.error();
        }
    }

    public String readDirection() {
        String direction = Console.readLine();
        validateDirection(direction);

        return direction;
    }

    private void validateDirection(String direction) {
        if (!(direction.equals(UP.getFirstLetter()) || direction.equals(DOWN.getFirstLetter()))) {
            INPUT_DIRECTION.error();
        }
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);

        return gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals(RETRY.getFirstLetter()) || gameCommand.equals(QUIT.getFirstLetter()))) {
            INPUT_GAME_COMMAND.error();
        }
    }

}
