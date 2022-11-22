package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.BridgeGameConstant.*;

public class InputView {

    private static final String MOVING_REGEX = "[" + UP_BRIDGE_BLOCK + DOWN_BRIDGE_BLOCK + "]";
    private static final String GAME_COMMAND_REGEX = "[" + RETRY_COMMAND + QUIT_COMMAND + "]";

    public int readBridgeSize() throws IllegalArgumentException {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() throws IllegalArgumentException {
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateBridgeSize(String bridgeSize) {
        validateBridgeSizeNumberFormat(bridgeSize);
        validateBridgeSizeRange(bridgeSize);
    }

    private void validateBridgeSizeNumberFormat(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_ONLY_INTEGER);
        }
    }

    private void validateBridgeSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < BRIDGE_SIZE_MIN || Integer.parseInt(bridgeSize) > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    private void validateMoving(String moving) {
        if (!moving.matches(MOVING_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING);
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches(GAME_COMMAND_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND);
        }
    }
}
