package bridge.utils.validator;

import static bridge.utils.Constant.*;


public class MoveValidator {

    private static final String NOT_VALID_MOVE = "유효한 이동이 아닙니다.";
    private final String move;

    public MoveValidator(String move) {
        this.move = move;
        isValidMove();
    }

    private void isValidMove() {
        if (!this.move.equals(UP) && !this.move.equals(DOWN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_VALID_MOVE);
        }
    }


}
