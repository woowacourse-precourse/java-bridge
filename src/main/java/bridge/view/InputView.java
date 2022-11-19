package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constant.BridgeGameConstant.*;

public class InputView {

    private static final String BRIDGE_SIZE_REGEX = "[0-9]+";
    private static final String MOVING_REGEX = "[" + UP_BRIDGE + DOWN_BRIDGE + "]";
    private static final String GAME_COMMAND_REGEX = "[" + RETRY_COMMAND + QUIT_COMMAND + "]";

    private static final class ExceptionMessage {
        private static final String PREFIX = "[ERROR] ";
        private static final String INVALID_BRIDGE_SIZE_ONLY_NUMBER = "다리 길이는 숫자이어야 합니다.";
        private static final String INVALID_BRIDGE_SIZE_RANGE = "다리 길이는 " + BRIDGE_SIZE_MIN + "부터 " + BRIDGE_SIZE_MAX + " 사이의 값이어야 합니다.";
        private static final String INVALID_MOVING = "이동할 칸은 " + UP_BRIDGE + " 또는 " + DOWN_BRIDGE + " 이어야 합니다.";
        private static final String INVALID_GAME_COMMAND = "게임 재시도 여부는 " + RETRY_COMMAND + " 또는 " + QUIT_COMMAND + " 이어야 합니다.";
    }

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
        if (!bridgeSize.matches(BRIDGE_SIZE_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.PREFIX + ExceptionMessage.INVALID_BRIDGE_SIZE_ONLY_NUMBER);
        }
        if (Integer.parseInt(bridgeSize) < BRIDGE_SIZE_MIN || Integer.parseInt(bridgeSize) > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.PREFIX + ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    private void validateMoving(String moving) {
        if (!moving.matches(MOVING_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.PREFIX + ExceptionMessage.INVALID_MOVING);
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches(GAME_COMMAND_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.PREFIX + ExceptionMessage.INVALID_GAME_COMMAND);
        }
    }
}
