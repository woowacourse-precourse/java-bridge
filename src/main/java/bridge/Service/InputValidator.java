package bridge.Service;

import bridge.Model.BridgeShape;
import bridge.Model.BridgeSize;
import bridge.Model.ErrorMessage;
import bridge.Model.GameResult;

public class InputValidator {

    private static int MIN_SIZE = BridgeSize.MIN_SIZE.getSize();
    private static int MAX_SIZE = BridgeSize.MAX_SIZE.getSize();
    public static final String UP = BridgeShape.UP.getShape();
    public static final String DOWN = BridgeShape.DOWN.getShape();
    public static final String RETRY = GameResult.RETRY.getResult();
    public static final String QUIT = GameResult.QUIT.getResult();

    public void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIZE_ERROR.getMessage());
        }
    }

    public void validateDigit(String input) {
        boolean result = input.chars()
                .allMatch(Character::isDigit);

        if (result == false) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DIGIT_ERROR.getMessage());
        }
    }

    public void validateMoving(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MOVING_ERROR.getMessage());
        }
    }

    public void validateCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_COMMAND_ERROR.getMessage());
        }
    }
}
