package bridge.util;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.repository.BridgeInfo;
import bridge.systemMessage.ErrorMessage;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.getMessage());
        }
    }

    public static void validateSize(int size) {
        if (size < BridgeMaker.getBridgeMinSize() || size > BridgeMaker.getBridgeMaxSize()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_SIZE_ERROR.getMessage());
        }
    }

    public static void validateMoving(String input) {
        if (!input.equals(BridgeInfo.UP_BRIDGE.getLetter()) && !input.equals(BridgeInfo.DOWN_BRIDGE.getLetter())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MOVING_INPUT_ERROR.getMessage());
        }
    }

    public static void validateGameCommand(String input) {
        if (!input.equals(BridgeGame.getRetryCommand()) && !input.equals(BridgeGame.getQuitCommand())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_RETRY_OR_QUIT_INPUT_ERROR.getMessage());
        }
    }
}
