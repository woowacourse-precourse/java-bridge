package bridge.input.validator;

import bridge.constant.Move;

public class MoveValidator {
    private static final String UP = Move.UP.getValue();
    private static final String DOWN = Move.DOWN.getValue();

    public boolean isValidMove(String userInputForMove) {
        return userInputForMove.equals(UP) || userInputForMove.equals(DOWN);
    }
}
