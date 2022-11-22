package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.Constants.*;
import static bridge.domain.exception.ErrorMessage.*;

public class InputView {

    public int readBridgeSize() {
        int bridgeSize = parseBridgeSizeToInt(Console.readLine());
        validateBrideSize(bridgeSize);
        return bridgeSize;
    }

    private int parseBridgeSizeToInt(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    private void validateBrideSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE);
        }
    }

    public String readMoving() {
        String moving = Console.readLine();
        validateBridgeMoving(moving);
        return moving;
    }

    private void validateBridgeMoving(String moving) {
        if (!moving.equals(UP) && !moving.equals(DOWN)) {
            throw new IllegalArgumentException(ERROR_MOVING_VALUE);
        }
    }

    public String readGameCommand() {
        String command = Console.readLine();
        validateGameCommnd(command);
        return command;
    }

    private void validateGameCommnd(String command) {
        if (!command.equals(RETRY) && !command.equals(QUIT)) {
            throw new IllegalArgumentException(ERROR_GAME_COMMAND);
        }
    }
}
