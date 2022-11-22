package bridge.validation;

import bridge.view.MoveInputExceptionMessage;
import bridge.command.UserMove;

public class MoveInputException {
    private static final String SMALL_LETTER_UP = "u";
    private static final String SMALL_LETTER_DOWN = "d";

    public static void validateMoveInput(String upAndDown) {
        checkInputUpAndDownCapital(upAndDown);
        checkInputUpAndDownRight(upAndDown);
    }

    private static void checkInputUpAndDownCapital(String upAndDown) {
        if (upAndDown.equals(SMALL_LETTER_UP) || upAndDown.equals(SMALL_LETTER_DOWN)) {
            throw new IllegalArgumentException(MoveInputExceptionMessage.SMALL_LETTER_EXCEPTION_MESSAGE.getMoveInputExceptionMessage());
        }
    }

    private static void checkInputUpAndDownRight(String upAndDown) {
        if ((!upAndDown.equals(UserMove.UP.getUserMove()) && !upAndDown.equals(UserMove.DOWN.getUserMove()))) {
            throw new IllegalArgumentException(MoveInputExceptionMessage.NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE.getMoveInputExceptionMessage());
        }
    }
}
